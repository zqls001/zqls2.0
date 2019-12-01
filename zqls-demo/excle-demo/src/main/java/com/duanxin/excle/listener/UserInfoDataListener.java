package com.duanxin.excle.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.duanxin.excle.mapper.DemoMapper;
import com.duanxin.excle.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/26 11:01
 */
public class UserInfoDataListener extends AnalysisEventListener<UserInfo> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     * */
    private static final int BATCH_COUNT = 5;
    List<UserInfo> list = new ArrayList<>();

    private DemoMapper demoMapper;

    public UserInfoDataListener() {
        demoMapper = new DemoMapper();
    }

    public UserInfoDataListener(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    /**
     * 每条数据解析完调用
     * @param data 数据
     * @param context 数据解析器
     * @date 2019/11/26 11:08
     **/
    @Override
    public void invoke(UserInfo data, AnalysisContext context) {
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            demoMapper.save(list);
            list.clear();
        }
    }

    /**
     * 所有数据解析完调用
     * @param context 数据解析器
     * @date 2019/11/26 11:08
     **/
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        demoMapper.save(list);
    }
}
