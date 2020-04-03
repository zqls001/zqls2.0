package com.duanxin.zqls.umps.ao;

import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.model.UmsRole;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 角色权限应用对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/30 9:11
 */
public class UmsAclRoleAo implements Serializable {

    public UmsAclRoleAo() {
    }

    private static final long serialVersionUID = -3061613479549444508L;

    private int checkCode;

    private UmsRole umsRole;

    private List<UmsAcl> umsAcls;

    public int getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(int checkCode) {
        this.checkCode = checkCode;
    }

    public UmsRole getUmsRole() {
        return umsRole;
    }

    public void setUmsRole(UmsRole umsRole) {
        this.umsRole = umsRole;
    }

    public List<UmsAcl> getUmsAcls() {
        return umsAcls;
    }

    public void setUmsAcls(List<UmsAcl> umsAcls) {
        this.umsAcls = umsAcls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsAclRoleAo that = (UmsAclRoleAo) o;

        if (checkCode != that.checkCode) {
            return false;
        }
        if (!Objects.equals(umsRole, that.umsRole)) {
            return false;
        }
        return Objects.equals(umsAcls, that.umsAcls);
    }

    @Override
    public int hashCode() {
        int result = checkCode;
        result = 31 * result + (umsRole != null ? umsRole.hashCode() : 0);
        result = 31 * result + (umsAcls != null ? umsAcls.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsAclRoleAo{" +
                "checkCode=" + checkCode +
                ", umsRole=" + umsRole +
                ", umsAcls=" + umsAcls +
                '}';
    }
}
