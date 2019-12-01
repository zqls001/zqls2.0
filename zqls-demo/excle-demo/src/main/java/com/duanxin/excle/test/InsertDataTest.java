package com.duanxin.excle.test;

import com.alibaba.excel.EasyExcel;
import com.duanxin.excle.listener.UmsUserInfoDataListener;
import com.duanxin.excle.listener.UserInfoDataListener;
import com.duanxin.excle.model.FmsMealRecommendationParameters;
import com.duanxin.excle.model.FmsUserLike;
import com.duanxin.excle.dto.UmsUserInfoDto;
import org.junit.Test;

import java.io.File;

/**
 * 测试
 * @author duanxin
 * @version 1.0
 * @date 2019/11/26 11:00
 */
public class InsertDataTest {

    @Test
    public void insertUmsUserInfo() {
        String fileName = InsertDataTest.class.getResource("/").getPath() + "excleFile" + File.separator + "用户属性.xls";
        EasyExcel.read(fileName, UmsUserInfoDto.class, new UmsUserInfoDataListener()).sheet().doRead();
    }

    @Test
    public void insertFmsUserLike() {
        String fileName = InsertDataTest.class.getResource("/").getPath() + "excleFile" + File.separator + "用户属性.xls";
        EasyExcel.read(fileName, FmsUserLike.class, new UserInfoDataListener()).sheet().doRead();
    }

    @Test
    public void insertFmsMealRecommendationParameters() {
        String fileName = InsertDataTest.class.getResource("/").getPath() + "excleFile" + File.separator + "用户属性.xls";
        EasyExcel.read(fileName, FmsMealRecommendationParameters.class, new UserInfoDataListener()).sheet().doRead();
    }
}
