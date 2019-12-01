package com.duanxin.excle.test;

import com.alibaba.excel.EasyExcel;
import com.duanxin.excle.listener.UserInfoDataListener;
import com.duanxin.excle.mapper.DemoMapper;
import com.duanxin.excle.model.UserInfo;
import org.junit.Test;

import java.io.File;

/**
 * 测试
 * @author duanxin
 * @version 1.0
 * @date 2019/11/26 11:00
 */
public class SimpleTest {

    @Test
    public void simpleRead() {
        String fileName = SimpleTest.class.getResource("/").getPath() + "excleFile" + File.separator + "用户属性.xls";
        EasyExcel.read(fileName, UserInfo.class, new UserInfoDataListener()).sheet().doRead();
    }

    private void simpleWrite() {
        String fileName = SimpleTest.class.getResource("/").getPath() + "excleFile" + File.separator + "用户属性.xls";
        EasyExcel.write(fileName, UserInfo.class).sheet().doWrite(DemoMapper.writeData());
    }

    @Test
    public void writeData() {
        simpleRead();
        simpleWrite();
    }

    public void writeIdToFile() {
        String fileName = SimpleTest.class.getResource("/").getPath() + "excleFile" + File.separator + "用户属性.xls";
        EasyExcel.write(fileName, UserInfo.class).sheet().doWrite(DemoMapper.writeData());
    }
}
