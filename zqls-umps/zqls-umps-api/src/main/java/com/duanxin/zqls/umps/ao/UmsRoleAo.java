package com.duanxin.zqls.umps.ao;

import com.duanxin.zqls.umps.model.UmsRole;
import lombok.*;

import java.io.Serializable;

/**
 * 角色应用对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/15 9:52
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UmsRoleAo implements Serializable {

    private static final long serialVersionUID = -5705718005407458891L;
    private UmsRole umsRole;

    private int checkCode;
}
