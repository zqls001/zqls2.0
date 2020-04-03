package com.duanxin.zqls.ucenter.vo;

import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 用户信息显示层对象
 * @author duanxin
 * @version 1.0
 * @date 2019/10/26 10:29
 */
@ApiModel(description = "用户信息展示前端页面实体类")
public class UmsUserInfoVo implements Serializable {

    public UmsUserInfoVo() {
    }

    private static final long serialVersionUID = -2834690137786115839L;
    /**
     * 用户账户
     * */
    @ApiModelProperty(name = "umsUserAccountInfoList", value = "用户账户信息",
            dataType = "List<UmsUserAccountInfo>")
    private List<UmsUserAccountInfo> umsUserAccountInfoList;

    /**
     * 用户信息对象
     * */
    @ApiModelProperty(name = "umsUserInfo", value = "用户基本信息实体类",
            dataType = "UmsUserInfo", required = true)
    private UmsUserInfo umsUserInfo;

    public List<UmsUserAccountInfo> getUmsUserAccountInfoList() {
        return umsUserAccountInfoList;
    }

    public void setUmsUserAccountInfoList(List<UmsUserAccountInfo> umsUserAccountInfoList) {
        this.umsUserAccountInfoList = umsUserAccountInfoList;
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

        UmsUserInfoVo that = (UmsUserInfoVo) o;

        if (!Objects.equals(umsUserAccountInfoList, that.umsUserAccountInfoList)) {
            return false;
        }
        return Objects.equals(umsUserInfo, that.umsUserInfo);
    }

    @Override
    public int hashCode() {
        int result = umsUserAccountInfoList != null ? umsUserAccountInfoList.hashCode() : 0;
        result = 31 * result + (umsUserInfo != null ? umsUserInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsUserInfoVo{" +
                "umsUserAccountInfoList=" + umsUserAccountInfoList +
                ", umsUserInfo=" + umsUserInfo +
                '}';
    }
}
