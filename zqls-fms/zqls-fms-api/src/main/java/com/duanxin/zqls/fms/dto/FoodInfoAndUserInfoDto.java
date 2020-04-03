package com.duanxin.zqls.fms.dto;

import com.duanxin.zqls.fms.model.FmsFoodInfo;
import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 向硬件系统传递数据的封装对象
 * @author duanxin
 * @version 1.0
 * @date 2019/11/23 11:03
 */
public class FoodInfoAndUserInfoDto implements Serializable {

    public FoodInfoAndUserInfoDto() {
    }

    private static final long serialVersionUID = -1389906432853819520L;
    /**
     * 食物信息
     * */
    private FmsFoodInfo fmsFoodInfo;

    /**
     * 用户个人账户信息
     * */
    private UmsUserAccountInfo umsUserAccountInfo;

    /**
     * 用户个人基本信息
     * */
    private UmsUserInfo umsUserInfo;

    public FmsFoodInfo getFmsFoodInfo() {
        return fmsFoodInfo;
    }

    public void setFmsFoodInfo(FmsFoodInfo fmsFoodInfo) {
        this.fmsFoodInfo = fmsFoodInfo;
    }

    public UmsUserAccountInfo getUmsUserAccountInfo() {
        return umsUserAccountInfo;
    }

    public void setUmsUserAccountInfo(UmsUserAccountInfo umsUserAccountInfo) {
        this.umsUserAccountInfo = umsUserAccountInfo;
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

        FoodInfoAndUserInfoDto that = (FoodInfoAndUserInfoDto) o;

        if (!Objects.equals(fmsFoodInfo, that.fmsFoodInfo)) {
            return false;
        }
        if (!Objects.equals(umsUserAccountInfo, that.umsUserAccountInfo)) {
            return false;
        }
        return Objects.equals(umsUserInfo, that.umsUserInfo);
    }

    @Override
    public int hashCode() {
        int result = fmsFoodInfo != null ? fmsFoodInfo.hashCode() : 0;
        result = 31 * result + (umsUserAccountInfo != null ? umsUserAccountInfo.hashCode() : 0);
        result = 31 * result + (umsUserInfo != null ? umsUserInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FoodInfoAndUserInfoDto{" +
                "fmsFoodInfo=" + fmsFoodInfo +
                ", umsUserAccountInfo=" + umsUserAccountInfo +
                ", umsUserInfo=" + umsUserInfo +
                '}';
    }
}
