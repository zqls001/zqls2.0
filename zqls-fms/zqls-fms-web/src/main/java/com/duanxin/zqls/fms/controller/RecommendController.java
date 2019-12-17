package com.duanxin.zqls.fms.controller;


import com.duanxin.zqls.web.base.BaseResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 推荐模块Controller接口
 * @author duanxin
 * @version 1.0
 * @date 2019/12/7 10:52
 */
@RestController
@Api(value = "推荐模块业务接口", tags = {"推荐模块的Controller接口"})
@RequestMapping("/recommend")
public class RecommendController {

    public BaseResult getFoodProductionRecommendation() {
        return null;
    }
}
