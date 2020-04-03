package com.duanxin.zqls.ucenter.ao;

import com.duanxin.zqls.ucenter.model.FeedbackInfo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 反馈信息应用对象
 * @author duanxin
 * @version 1.0
 * @date 2019/12/10 10:42
 */
public class FeedbackInfoAo implements Serializable {

    private static final long serialVersionUID = 8585631662051127255L;

    public FeedbackInfoAo() {
    }

    private int checkCode;

    private FeedbackInfo feedbackInfo;

    public int getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(int checkCode) {
        this.checkCode = checkCode;
    }

    public FeedbackInfo getFeedbackInfo() {
        return feedbackInfo;
    }

    public void setFeedbackInfo(FeedbackInfo feedbackInfo) {
        this.feedbackInfo = feedbackInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FeedbackInfoAo that = (FeedbackInfoAo) o;

        if (checkCode != that.checkCode) {
            return false;
        }
        return Objects.equals(feedbackInfo, that.feedbackInfo);
    }

    @Override
    public int hashCode() {
        int result = checkCode;
        result = 31 * result + (feedbackInfo != null ? feedbackInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FeedbackInfoAo{" +
                "checkCode=" + checkCode +
                ", feedbackInfo=" + feedbackInfo +
                '}';
    }
}
