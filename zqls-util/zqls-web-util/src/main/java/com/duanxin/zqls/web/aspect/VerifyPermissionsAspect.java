package com.duanxin.zqls.web.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 验证用户权限的切面
 * @author duanxin
 * @version 1.0
 * @date 2020/3/6 15:22
 */
@Component
@Aspect
@Order(2)
public class VerifyPermissionsAspect {

//    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
//    private UmsUserInfoService umsUserInfoService;
//    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
//    private UmsUserRoleService umsUserRoleService;
//    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
//    private UmsAclRoleService umsAclRoleService;
//    @Reference(version = "0.0.1", check = false, mock = "true", protocol = "dubbo")
//    private UmsAclService umsAclService;
//
//    @Pointcut("@annotation(com.duanxin.zqls.web.annotation.VerifyPermissions)")
//    public void verify(){}
//
//    @Before("verify()")
//    public void doBefore(JoinPoint pjp) throws Throwable {
//        // 检查该请求是否需要进行权限校验
//        Signature signature = pjp.getSignature();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        Method method = methodSignature.getMethod();
//        if (!method.isAnnotationPresent(VerifyPermissions.class)) {
//            // 该请求不需权限校验
//            return ;
//        }
//        // 从cookie中获取学工号
//        String jobNumber = HttpUtil.getData("jobNumber");
//        // 从请求中获取请求路径、请求类型
//        HttpServletRequest request = HttpUtil.getRequest();
//        String url = request.getRequestURL().toString();
//        String requestType = request.getMethod();
//        // 查询用户信息
//        UmsUserInfo umsUserInfo = umsUserInfoService.selectByJobNumber(jobNumber);
//        String type = umsUserInfo.getType();
//        if ("0".equals(type)) {
//            // 学生用户无需进行校验
//            return ;
//        }
//        // 进行用户权限校验
//        // 获取用户角色身份
//        List<Integer> rids = umsUserRoleService.selectRidsByUid(umsUserInfo.getId());
//        if (CollectionUtils.isEmpty(rids)) {
//            throw new ValidateException("用户无权限，请联系超级管理员");
//        }
//        // 查询角色权限
//        List<Integer> aids = umsAclRoleService.selectAidsByRids(rids);
//        if (CollectionUtils.isEmpty(aids)) {
//            throw new ValidateException("用户无权限，请联系超级管理");
//        }
//        // 查询权限信息
//        List<UmsAcl> umsAcls = umsAclService.selectAclsByIds(aids);
//        // 遍历进行校验
//        umsAcls.forEach(u -> {
//            String url1 = u.getUrl();
//            String requestType1 = RequestTypeEnum.getValueByType(u.getRequestType());
//            if (url.equals(url1) && requestType.equals(requestType1)) {
//                return ;
//            }
//        });
//        throw new ValidateException("用户无权限");
//    }
//
//    @AfterReturning(value = "verify()", returning = "ret")
//    public void doAfterReturn(Object ret) throws Throwable {}
}
