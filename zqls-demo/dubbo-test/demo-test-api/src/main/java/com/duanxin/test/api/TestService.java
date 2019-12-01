package com.duanxin.test.api;

import com.duanxin.test.model.UmsUserAccountInfo;
import com.duanxin.test.model.UmsUserInfo;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/24 9:48
 */
public interface TestService {

    UmsUserInfo selectByPrimaryKey(Integer id);

    UmsUserAccountInfo selectUserAccountInfoByPrimaryKey(Integer id);
}
