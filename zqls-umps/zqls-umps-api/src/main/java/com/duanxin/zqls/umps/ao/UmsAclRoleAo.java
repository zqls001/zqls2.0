package com.duanxin.zqls.umps.ao;

import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.model.UmsRole;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 角色权限应用对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/30 9:11
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAclRoleAo implements Serializable {
    private static final long serialVersionUID = -3061613479549444508L;

    private int checkCode;

    private UmsRole umsRole;

    private List<UmsAcl> umsAcls;
}
