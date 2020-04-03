package com.duanxin.zqls.umps.ao;

import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.umps.model.UmsRole;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 用户角色应用对象
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:24
 */
public class UmsUserRoleAo implements Serializable {

    public UmsUserRoleAo() {
    }

    private static final long serialVersionUID = -6071196860709837122L;

    private int checkCode;

    private UmsRole umsRole;

    private List<UmsUserInfo> umsUserInfos;

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

    public List<UmsUserInfo> getUmsUserInfos() {
        return umsUserInfos;
    }

    public void setUmsUserInfos(List<UmsUserInfo> umsUserInfos) {
        this.umsUserInfos = umsUserInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsUserRoleAo that = (UmsUserRoleAo) o;

        if (checkCode != that.checkCode) {
            return false;
        }
        if (!Objects.equals(umsRole, that.umsRole)) {
            return false;
        }
        return Objects.equals(umsUserInfos, that.umsUserInfos);
    }

    @Override
    public int hashCode() {
        int result = checkCode;
        result = 31 * result + (umsRole != null ? umsRole.hashCode() : 0);
        result = 31 * result + (umsUserInfos != null ? umsUserInfos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsUserRoleAo{" +
                "checkCode=" + checkCode +
                ", umsRole=" + umsRole +
                ", umsUserInfos=" + umsUserInfos +
                '}';
    }
}
