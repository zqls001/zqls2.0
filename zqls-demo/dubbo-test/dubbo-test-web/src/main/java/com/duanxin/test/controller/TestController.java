package com.duanxin.test.controller;

import com.duanxin.test.api.TestService;
import com.duanxin.test.model.UmsUserAccountInfo;
import com.duanxin.test.model.UmsUserInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/24 9:56
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Reference
    private TestService testService;

    @GetMapping("/test/{id}")
    public UmsUserInfo test(@PathVariable("id") Integer id) {
        return testService.selectByPrimaryKey(id);
    }

    @GetMapping("/test2/{id}")
    public UmsUserAccountInfo test2(@PathVariable("id") Integer id) {
        return testService.selectUserAccountInfoByPrimaryKey(id);
    }
}
