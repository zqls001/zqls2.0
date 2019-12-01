package com.duanxin.excle;

import com.alibaba.excel.EasyExcel;
import com.duanxin.excle.dto.FmsMealRecommendationParametersDto;
import com.duanxin.excle.dto.FmsUserLikeDto;
import com.duanxin.excle.dto.UmsUserInfoDto;
import com.duanxin.excle.listener.FmsMealRecommendationParametersDataListener;
import com.duanxin.excle.listener.FmsUserLikeDataListener;
import com.duanxin.excle.listener.UmsUserInfoDataListener;
import com.duanxin.excle.service.SaveDataService;
import com.duanxin.excle.test.InsertDataTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/12/1 9:29
 */
@SpringBootApplication
@MapperScan("com.duanxin.excle.mapper")
@RestController
public class ExcleDemoApplication {

    @Resource
    private SaveDataService saveDataService;
    @Resource
    private UmsUserInfoDataListener umsUserInfoDataListener;
    @Resource
    private FmsUserLikeDataListener fmsUserLikeDataListener;
    @Resource
    private FmsMealRecommendationParametersDataListener fmsMealRecommendationParametersDataListener;

    public static void main(String[] args) {
        SpringApplication.run(ExcleDemoApplication.class, args);
    }

    @RequestMapping("/test")
    public String test() {
        saveDataService.test();
        return "success";
    }

    @RequestMapping("/insertUser")
    public String insertUser() {
        String fileName = InsertDataTest.class.getResource("/").getPath() + "excleFile" + File.separator + "用户属性.xls";
        EasyExcel.read(fileName, UmsUserInfoDto.class, umsUserInfoDataListener).sheet().doRead();
        return "success";
    }

    @RequestMapping("/writeId")
    public String writeId() {
        saveDataService.writeIdToFile();
        return "success";
    }

    @RequestMapping("/insertUserLike")
    public String insertUserLike() {
        String fileName = InsertDataTest.class.getResource("/").getPath() + "excleFile" + File.separator + "用户属性.xls";
        EasyExcel.read(fileName, FmsUserLikeDto.class, fmsUserLikeDataListener).sheet().doRead();
        return "success";
    }

    @RequestMapping("/insertFmsMealParameters")
    public String insertFmsMealParameters() {
        String fileName = InsertDataTest.class.getResource("/").getPath() + "excleFile" + File.separator + "新建 Microsoft Excel 工作表.xlsx";
        EasyExcel.read(fileName, FmsMealRecommendationParametersDto.class, fmsMealRecommendationParametersDataListener).sheet().doRead();
        return "success";
    }
}
