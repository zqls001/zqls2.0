package com.duanxin.zqls.ucenter.vo;

import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息显示层对象
 * @author duanxin
 * @version 1.0
 * @date 2019/10/26 10:29
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsUserInfoVo implements Serializable {

    private static final long serialVersionUID = -2834690137786115839L;
    /**
     * 用户账户
     * */
    private List<UmsUserAccountInfo> umsUserAccountInfoList;

    /**
     * 用户信息对象
     * */
    private UmsUserInfo umsUserInfo;
}
