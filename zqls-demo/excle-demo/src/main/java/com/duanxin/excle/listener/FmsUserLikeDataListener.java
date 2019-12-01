package com.duanxin.excle.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.duanxin.excle.dto.FmsUserLikeDto;
import com.duanxin.excle.service.SaveDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/28 9:53
 */
@Component
public class FmsUserLikeDataListener extends AnalysisEventListener<FmsUserLikeDto> {

    private static final int BATCH_COUNT = 1000;
    List<FmsUserLikeDto> list = new ArrayList<>();

    private SaveDataService saveDataService;

    public FmsUserLikeDataListener() {
        saveDataService = new SaveDataService();
    }

    @Autowired
    public FmsUserLikeDataListener(SaveDataService saveDataService) {
        this.saveDataService = saveDataService;
    }

    @Override
    public void invoke(FmsUserLikeDto data, AnalysisContext context) {
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveDataService.insertFmsUserLike(list);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveDataService.insertFmsUserLike(list);
    }
}
