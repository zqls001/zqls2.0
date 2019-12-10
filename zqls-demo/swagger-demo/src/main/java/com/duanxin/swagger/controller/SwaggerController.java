package com.duanxin.swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/12/5 16:13
 */
@Controller
public class SwaggerController {

    @GetMapping("/hello")
    @ResponseBody
    @ApiOperation(value = "接口的功能介绍", notes = "提示接口使用者注意事项", httpMethod = "GET", response = String.class)
    @ApiImplicitParam(dataType = "string", name = "name", value = "姓名", required = true)
    public String hello(String name) {
        return "swagger" + name;
    }

    @PostMapping("/test")
    @ResponseBody
    @ApiOperation(value = "接口的功能介绍", notes = "提示接口使用者注意事项", httpMethod = "POST", response = String.class)
    public String test(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getSize());
        return "test";
    }
}
