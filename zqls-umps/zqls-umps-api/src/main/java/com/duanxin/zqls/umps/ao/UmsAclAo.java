package com.duanxin.zqls.umps.ao;

import com.duanxin.zqls.umps.model.UmsAcl;

import java.io.Serializable;
import java.util.Objects;

/**
 * 权限应用对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 8:29
 */
public class UmsAclAo implements Serializable {

    public UmsAclAo() {
    }

    private static final long serialVersionUID = 7571627736090174134L;

    private int checkCode;

    private UmsAcl umsAcl;

    public int getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(int checkCode) {
        this.checkCode = checkCode;
    }

    public UmsAcl getUmsAcl() {
        return umsAcl;
    }

    public void setUmsAcl(UmsAcl umsAcl) {
        this.umsAcl = umsAcl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsAclAo umsAclAo = (UmsAclAo) o;

        if (checkCode != umsAclAo.checkCode) {
            return false;
        }
        return Objects.equals(umsAcl, umsAclAo.umsAcl);
    }

    @Override
    public int hashCode() {
        int result = checkCode;
        result = 31 * result + (umsAcl != null ? umsAcl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsAclAo{" +
                "checkCode=" + checkCode +
                ", umsAcl=" + umsAcl +
                '}';
    }
}
