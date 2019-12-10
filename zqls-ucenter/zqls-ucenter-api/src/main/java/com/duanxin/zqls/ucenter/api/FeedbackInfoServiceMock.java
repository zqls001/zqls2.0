package com.duanxin.zqls.ucenter.api;

import com.duanxin.zqls.ucenter.ao.FeedbackInfoAo;
import com.duanxin.zqls.ucenter.model.FeedbackInfo;
import com.github.pagehelper.PageInfo;

/**
 * 用户反馈信息服务降级接口
 * @author duanxin
 * @version 1.0
 * @date 2019/12/8 11:03
 */
public class FeedbackInfoServiceMock implements FeedbackInfoService {
    @Override
    public int saveFeedbackInfo(FeedbackInfo feedbackInfo) {
        return 0;
    }

    @Override
    public FeedbackInfoAo getFeedbackById(Integer id) {
        return null;
    }

    @Override
    public PageInfo<FeedbackInfo> getFeedbackByJobNumberWithPages(String jobNumber, int currentPage, int pageSize) {
        return null;
    }

    @Override
    public PageInfo<FeedbackInfo> getAll(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public FeedbackInfo updateFeedbackInfo(FeedbackInfo feedbackInfo) {
        return null;
    }

    @Override
    public int deleteFeedbackInfo(Integer id) {
        return 0;
    }
}
