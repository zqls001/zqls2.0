package com.duanxin.zqls.ucenter.ao;

import com.duanxin.zqls.ucenter.model.UmsUserInfo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用户信息应用对象
 * @author duanxin
 * @version 1.0
 * @date 2019/10/26 10:12
 */
public class UmsUserInfoAo implements Serializable {

    public UmsUserInfoAo() {
    }

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

    public int getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(int checkCode) {
        this.checkCode = checkCode;
    }

    public UmsUserInfo getUmsUserInfo() {
        return umsUserInfo;
    }

    public void setUmsUserInfo(UmsUserInfo umsUserInfo) {
        this.umsUserInfo = umsUserInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsUserInfoAo that = (UmsUserInfoAo) o;

        if (checkCode != that.checkCode) {
            return false;
        }
        return Objects.equals(umsUserInfo, that.umsUserInfo);
    }

    @Override
    public int hashCode() {
        int result = checkCode;
        result = 31 * result + (umsUserInfo != null ? umsUserInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsUserInfoAo{" +
                "checkCode=" + checkCode +
                ", umsUserInfo=" + umsUserInfo +
                '}';
    }
}
