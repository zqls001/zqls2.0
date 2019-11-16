package com.duanxin.zqls.ucenter.ao;

import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import lombok.*;

import java.io.Serializable;

/**
 * 用户信息应用对象
 * @author duanxin
 * @version 1.0
 * @date 2019/10/26 10:12
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UmsUserInfoAo implements Serializable {

    private static final long serialVersionUID = -1368739333786485970L;
    /**
     * service层与web层之间的校验码
     * 0：校验失败
     * 1：
     * */
    private int checkCode;

    /**
     * 用户信息对象
     * */
    private UmsUserInfo umsUserInfo;
}
