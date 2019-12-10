package com.duanxin.zqls.ucenter.api;

import com.duanxin.zqls.ucenter.ao.FeedbackInfoAo;
import com.duanxin.zqls.ucenter.model.FeedbackInfo;
import com.github.pagehelper.PageInfo;

/**
 * 用户反馈信息Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/12/8 11:01
 */
public interface FeedbackInfoService {
    /**
     * 用户添加反馈信息
     * @param feedbackInfo 反馈信息实体
     * @date 2019/12/8 11:13
     * @return int
     **/
    int saveFeedbackInfo(FeedbackInfo feedbackInfo);

    /**
     * 根据反馈主键id查询详情
     * @param id 反馈主键id
     * @date 2019/12/10 9:44
     * @return com.duanxin.zqls.ucenter.model.FeedbackInfo
     **/
    FeedbackInfoAo getFeedbackById(Integer id);

    /**
     * 分页查询用户反馈信息
     * @param jobNumber 用户学工号
     * @param currentPage 当前页
     * @param pageSize 一页大小
     * @date 2019/12/10 10:03
     * @return com.github.pagehelper.PageInfo<com.duanxin.zqls.ucenter.model.FeedbackInfo>
     **/
    PageInfo<FeedbackInfo> getFeedbackByJobNumberWithPages(String jobNumber, int currentPage, int pageSize);

    /**
     * 分页查询反馈信息
     * @param currentPage 当前页
     * @param pageSize 每页大小
     * @date 2019/12/10 10:10
     * @return com.github.pagehelper.PageInfo<com.duanxin.zqls.ucenter.model.FeedbackInfo>
     **/
    PageInfo<FeedbackInfo> getAll(int currentPage, int pageSize);

    /**
     * 更新反馈信息
     * @param feedbackInfo 待更新的实体
     * @date 2019/12/10 10:26
     * @return com.duanxin.zqls.ucenter.model.FeedbackInfo
     **/
    FeedbackInfo updateFeedbackInfo(FeedbackInfo feedbackInfo);

    /**
     * 删除反馈信息
     * @param id 反馈信息主键id
     * @date 2019/12/10 10:35
     * @return int
     **/
    int deleteFeedbackInfo(Integer id);
}
