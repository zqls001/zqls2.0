package com.duanxin.zqls.umps.ao;

import com.duanxin.zqls.umps.model.UmsRole;

import java.io.Serializable;
import java.util.Objects;

/**
 * 角色应用对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/15 9:52
 */
public class UmsRoleAo implements Serializable {

    public UmsRoleAo() {
    }

    private static final long serialVersionUID = -5705718005407458891L;
    private UmsRole umsRole;

    private int checkCode;

    public UmsRole getUmsRole() {
        return umsRole;
    }

    public void setUmsRole(UmsRole umsRole) {
        this.umsRole = umsRole;
    }

    public int getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(int checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsRoleAo umsRoleAo = (UmsRoleAo) o;

        if (checkCode != umsRoleAo.checkCode) {
            return false;
        }
        return Objects.equals(umsRole, umsRoleAo.umsRole);
    }

    @Override
    public int hashCode() {
        int result = umsRole != null ? umsRole.hashCode() : 0;
        result = 31 * result + checkCode;
        return result;
    }

    @Override
    public String toString() {
        return "UmsRoleAo{" +
                "umsRole=" + umsRole +
                ", checkCode=" + checkCode +
                '}';
    }
}

