package com.duanxin.zqls.ucenter.api;

/**
 * Jwt Service 降级服务
 * @author duanxin
 * @version 1.0
 * @date 2019/12/15 10:11
 */
public class JwtServiceMock implements JwtService {
    @Override
    public String login(String jobNumber, String password) {
        return null;
    }

    @Override
    public String refreshJwt(String jwt) {
        return null;
    }

    @Override
    public boolean checkJwt(String jwt) {
        return false;
    }

    @Override
    public int inValid(String jwt) {
        return 0;
    }
}
