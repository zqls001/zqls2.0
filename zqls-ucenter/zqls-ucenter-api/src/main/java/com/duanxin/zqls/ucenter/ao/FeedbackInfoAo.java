package com.duanxin.zqls.ucenter.ao;

import com.duanxin.zqls.ucenter.model.FeedbackInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 反馈信息应用对象
 * @author duanxin
 * @version 1.0
 * @date 2019/12/10 10:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackInfoAo {

    private int checkCode;

    private FeedbackInfo feedbackInfo;
}
