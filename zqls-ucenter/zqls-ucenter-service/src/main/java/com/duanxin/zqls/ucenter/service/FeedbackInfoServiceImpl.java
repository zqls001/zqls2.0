package com.duanxin.zqls.ucenter.service;

import com.duanxin.zqls.common.util.Builder;
import com.duanxin.zqls.ucenter.ao.FeedbackInfoAo;
import com.duanxin.zqls.ucenter.api.FeedbackInfoService;
import com.duanxin.zqls.ucenter.mapper.FeedbackInfoMapper;
import com.duanxin.zqls.ucenter.model.FeedbackInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户反馈信息Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/12/8 11:04
 */
@Service(version = "0.0.1", delay = -1)
public class FeedbackInfoServiceImpl implements FeedbackInfoService {

    @Resource
    private FeedbackInfoMapper feedbackInfoMapper;

    private final static Logger log = LoggerFactory.getLogger(FeedbackInfoServiceImpl.class);

    @Override
    public int saveFeedbackInfo(FeedbackInfo feedbackInfo) {
        // 判断是否有图片
        if (Byte.valueOf("1").equals(feedbackInfo.getIsPic())) {
            // 设置图片url
            feedbackInfo.setPicUrl(feedbackInfo.getPicUrl());
        }
        // 添加数据到数据库中
        feedbackInfo.setStatus(Byte.valueOf("0"));
        // 返回结果
        return feedbackInfoMapper.insertSelective(feedbackInfo);
    }

    @Override
    public FeedbackInfoAo getFeedbackById(Integer id) {
        FeedbackInfoAo feedbackInfoAo = new FeedbackInfoAo();
        FeedbackInfo feedbackInfo = feedbackInfoMapper.selectByPrimaryKey(id);
        if (null == feedbackInfo) {
            feedbackInfoAo.setCheckCode(1);
        }
        feedbackInfoAo.setFeedbackInfo(feedbackInfo);
        return feedbackInfoAo;
    }

    @Override
    public PageInfo<FeedbackInfo> getFeedbackByJobNumberWithPages(String jobNumber, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<FeedbackInfo> feedbackInfos =
                feedbackInfoMapper.select(Builder.of(FeedbackInfo::new).
                        with(FeedbackInfo::setUid, jobNumber).
                        build());
        return new PageInfo<>(feedbackInfos);
    }

    @Override
    public PageInfo<FeedbackInfo> getAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<FeedbackInfo> feedbackInfos = feedbackInfoMapper.selectAll();
        return new PageInfo<>(feedbackInfos);
    }

    @Override
    public FeedbackInfo updateFeedbackInfo(FeedbackInfo feedbackInfo) {
        feedbackInfo.setRenewTime(new Date());
        feedbackInfoMapper.updateByPrimaryKeySelective(feedbackInfo);
        return feedbackInfoMapper.selectByPrimaryKey(feedbackInfo.getId());
    }

    @Override
    public int deleteFeedbackInfo(Integer id) {
        if (null == feedbackInfoMapper.selectByPrimaryKey(id)) {
            return 2;
        }
        return feedbackInfoMapper.deleteByPrimaryKey(id);
    }
}
