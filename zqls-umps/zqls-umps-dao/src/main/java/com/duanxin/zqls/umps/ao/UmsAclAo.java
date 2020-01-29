package com.duanxin.zqls.umps.ao;

import com.duanxin.zqls.umps.model.UmsAcl;
import lombok.*;

import java.io.Serializable;

/**
 * 权限应用对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 8:29
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAclAo implements Serializable {
    private static final long serialVersionUID = 7571627736090174134L;

    private int checkCode;

    private UmsAcl umsAcl;
}
