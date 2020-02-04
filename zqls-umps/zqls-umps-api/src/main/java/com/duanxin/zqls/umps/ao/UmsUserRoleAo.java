package com.duanxin.zqls.umps.ao;

import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.umps.model.UmsRole;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 用户角色应用对象
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:24
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UmsUserRoleAo implements Serializable {
    private static final long serialVersionUID = -6071196860709837122L;

    private int checkCode;

    private UmsRole umsRole;

    private List<UmsUserInfo> umsUserInfos;
}
