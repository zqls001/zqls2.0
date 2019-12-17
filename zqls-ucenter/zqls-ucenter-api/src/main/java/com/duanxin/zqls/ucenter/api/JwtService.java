package com.duanxin.zqls.ucenter.api;

/**
 * JwtService接口
 * @author duanxin
 * @version 1.0
 * @date 2019/12/15 10:11
 */
public interface JwtService {

    /**
     * 用户登入
     * @param jobNumber 学工号
     * @param password 密码
     * @date 2019/12/15 10:14
     * @return String
     **/
    String login(String jobNumber, String password);

    /**
     * 过期时间小于3天，返回新的jwt，否则返回旧的jwt
     * @param jwt 旧的jwt
     * @date 2019/12/15 10:15
     * @return String
     **/
    String refreshJwt(String jwt);

    /**
     * 检查jwt的时效性
     * @param jwt 待校验的jwt
     * @date 2019/12/15 10:18
     * @return boolean
     **/
    boolean checkJwt(String jwt);

    /**
     * 使jwt失效
     * @param jwt jwt
     * @date 2019/12/15 10:19
     * @return int
     **/
    int inValid(String jwt);
}
