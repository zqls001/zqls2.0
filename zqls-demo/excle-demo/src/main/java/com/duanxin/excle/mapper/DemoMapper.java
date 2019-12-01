package com.duanxin.excle.mapper;

import com.duanxin.excle.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/26 11:04
 */
public class DemoMapper {

    private static List<UserInfo> data = new ArrayList<>();

    public void save(List<UserInfo> list) {
        data.addAll(list);
    }

    public static List<UserInfo> writeData() {
        List<UserInfo> list = new ArrayList<>();
        data.forEach(userInfo ->{
            UserInfo user = new UserInfo();
            user.setMail(userInfo.getPhone() + "@163.com");
            list.add(user);
        });
        return list;
    }
}
