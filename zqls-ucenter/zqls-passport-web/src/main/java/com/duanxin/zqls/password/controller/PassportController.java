package com.duanxin.zqls.password.controller;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.common.util.MD5Util;
import com.duanxin.zqls.ucenter.ao.UmsUserInfoAo;
import com.duanxin.zqls.ucenter.api.UmsUserInfoService;
import com.duanxin.zqls.ucenter.dto.UmsUserInfoDto;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.web.base.BaseResult;
import com.duanxin.zqls.web.util.CookieUtil;
import com.duanxin.zqls.web.util.HttpUtil;
import com.duanxin.zqls.web.validate.LengthValidator;
import com.duanxin.zqls.web.validate.NotNullValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 认证中心Controller层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/12/15 16:25
 */
@RestController
@RequestMapping("/passport")
@Api(value = "认证中心模块接口", tags = {"认证中心Controller接口"})
public class PassportController {

    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
    private UmsUserInfoService umsUserInfoService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public final static String REDIS_USER_TOKEN = "redis_user_token";
    public final static String REDIS_USER_TICKET = "redis_user_ticket";
    public final static String REDIS_TMP_TICKET = "redis_tmp_ticket";
    public final static String COOKIE_USER_TICKET = "cookie_user_ticket";

    /**
     * CAS的统一登录接口：
     *      目的：
     *          1.登录后创建用户的全局会话                    --》 uniqueToken
     *          2.创建用户全局门票，用以表示在CAS端是否登录    --》 userTicket
     *          3.创建用户的临时票据，用以回跳回传             --》 tmpTicket
     * @date 2020/4/3 8:57
     * @return com.duanxin.zqls.web.base.BaseResult
     **/
    @PostMapping("/login")
    @ApiOperation(value = "登入", notes = "用户提供学工号和密码进行登入",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "jobNumber", value = "用户学工号",
                    required = true, dataType = "String", example = "10200001"),
            @ApiImplicitParam(name = "password", value = "用户密码",
                    required = true, dataType = "String", example = "123456")
    })
    public BaseResult login(@RequestParam(value = "jobNumber") String jobNumber,
                            @RequestParam(value = "password") String password,
                            HttpServletResponse response) {
        Result result = FluentValidator.checkAll()
                .on(jobNumber, new NotNullValidator("学工号"))
                .on(password, new NotNullValidator("密码"))
                .on(jobNumber, new LengthValidator(7, 9, "学工号"))
                .on(password, new LengthValidator(5, 101, "密码"))
                .doValidate()
                .result(ResultCollectors.toSimple());
        // 校验失败，返回错误信息
        if (!result.isSuccess()) {
            return BaseResult.validateFailed(GsonUtil.objectToString(result.getErrors()));
        }
        // 1、实现登录
        UmsUserInfoAo umsUserInfoAo = umsUserInfoService.selectInfoForLogin(jobNumber, MD5Util.md5(password));
        if (null == umsUserInfoAo) {
            return BaseResult.failed("系统维护中，请耐心等待。。。。");
        }
        UmsUserInfo umsUserInfo = umsUserInfoAo.getUmsUserInfo();
        if (null == umsUserInfo) {
            return BaseResult.failed("学工号或密码不正确");
        }

        // 2、实现用户的redis会话
        String uniqueToken = UUID.randomUUID().toString().trim();
        UmsUserInfoDto umsUserInfoDto = new UmsUserInfoDto();
        BeanUtils.copyProperties(umsUserInfo, umsUserInfoDto);
        umsUserInfoDto.setUserUniqueToken(uniqueToken);
        stringRedisTemplate.opsForValue().set(REDIS_USER_TOKEN + ":" + umsUserInfo.getJobNumber(),
                                                GsonUtil.objectToString(umsUserInfoDto));

        // 3、生成ticket门票，全局门票，表示用户在CAS端登录过
        String userTicket = UUID.randomUUID().toString().trim();
        // 3.1、把全局门票加入到CAS端的Cookie中
        setCookie(COOKIE_USER_TICKET, userTicket, response);

        // 4、userTicket关联用户id，存入redis
        stringRedisTemplate.opsForValue().set(REDIS_USER_TICKET + ":" + userTicket, umsUserInfo.getJobNumber());

        // 5、生成临时票据，返回给用户端，这是CAS签发的一次性的临时票据
        String tmpTicket = UUID.randomUUID().toString().trim();
        stringRedisTemplate.opsForValue().set(REDIS_TMP_TICKET + ":" + tmpTicket,
                                                Objects.requireNonNull(MD5Util.md5(tmpTicket)),
                                        1, TimeUnit.HOURS);
        // 5.1、将临时票据存入客户端Cookie中
        CookieUtil.setCookie(response, "tmpTicket", tmpTicket, 3600);
        return BaseResult.success(tmpTicket);
    }

    @PostMapping("/verifyTmpTicket")
    @ApiOperation(value = "校验临时票据", notes = "用户进行是否登入过校验",
            httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParam(name = "tmpTicket", value = "客户端传来的临时票据",
            dataType = "String", required = true)
    public BaseResult verifyTmpTicket(@RequestParam("tmpTicket") String tmpTicket,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {

        // 使用一次性临时票据来验证用户是否登录过，如果登录过，把用户会话信息返回回去
        // 使用完毕，销毁临时票据
        String tmpTicketValue = stringRedisTemplate.opsForValue().get(REDIS_TMP_TICKET + ":" + tmpTicket);
        if (StringUtils.isBlank(tmpTicketValue)) {
            return BaseResult.validateFailed("用户票据异常");
        }
        // 1、如果临时票据OK，则进行销毁，并且拿到CAS端Cookie中的全局门票userTicket，用于获取用户会话中的信息
        if (!tmpTicketValue.equals(MD5Util.md5(tmpTicket))) { // 临时票据异常
            return BaseResult.validateFailed("用户票据异常");
        } else { // 临时票据OK
            // 销毁临时票据
            stringRedisTemplate.delete(REDIS_TMP_TICKET + ":" + tmpTicket);
        }
        // 2、从CAS的Cookie中获取全局门票userTicket
        // String userTicket = CookieUtil.getCookie(request, COOKIE_USER_TICKET);
        String userTicket = HttpUtil.getData(COOKIE_USER_TICKET);
        // 2.1、获取用户id
        String jobNumber = stringRedisTemplate.opsForValue().get(REDIS_USER_TICKET + ":" + userTicket);
        if (StringUtils.isBlank(jobNumber)) {
            return BaseResult.validateFailed("用户票据异常");
        }

        // 3、验证门票对应的user会话是否存在
        String userToken = stringRedisTemplate.opsForValue().get(REDIS_USER_TOKEN + ":" + jobNumber);
        if (StringUtils.isBlank(userToken)) {
            return BaseResult.validateFailed("用户票据异常");
        }
        // 验证成功，返回用户信息
        return BaseResult.success("OK", GsonUtil.jsonToBean(userToken, UmsUserInfoDto.class));
    }

    @GetMapping("/refreshTmpTicket")
    @ApiOperation(value = "更新临时票据", httpMethod = "GET", response = BaseResult.class)
    public BaseResult refreshTmpTicket() {
        String tmpTicket = UUID.randomUUID().toString().trim();
        stringRedisTemplate.opsForValue().set(REDIS_TMP_TICKET + ":" + tmpTicket,
                Objects.requireNonNull(MD5Util.md5(tmpTicket)),
                1, TimeUnit.HOURS);

        return BaseResult.success(tmpTicket);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "退出登入", httpMethod = "POST", response = BaseResult.class)
    @ApiImplicitParam(name = "jobNumber", value = "用户学工号",
            dataType = "String", required = true)
    public BaseResult logout(@RequestParam("jobNumber") String jobNumber,
                             HttpServletResponse response,
                             HttpServletRequest request) {
        // 1、获取CAS中的用户门票
        String userTicket = CookieUtil.getCookie(request, COOKIE_USER_TICKET);

        // 2、清除ticket门票，redis/cookie
        CookieUtil.removeCookie(response, COOKIE_USER_TICKET);
        stringRedisTemplate.delete(REDIS_USER_TICKET + ":" + userTicket);

        // 3、清除用户全局会话
        stringRedisTemplate.delete(REDIS_USER_TOKEN + ":" + jobNumber);
        return BaseResult.success("退出成功");
    }

    /**
     * 给CAS端设置cookie
     * */
    private void setCookie(String key, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(key, value);
        // cookie.setDomain("sso.com");
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
