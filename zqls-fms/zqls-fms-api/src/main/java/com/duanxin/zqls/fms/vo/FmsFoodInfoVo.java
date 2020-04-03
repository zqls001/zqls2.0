package com.duanxin.zqls.fms.vo;

import com.duanxin.zqls.fms.model.FmsFoodInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * food info view object
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 10:49
 */
@ApiModel(description = "食物信息展示实体类")
public class FmsFoodInfoVo implements Serializable {

    private static final long serialVersionUID = -5736695422026046402L;

    public FmsFoodInfoVo() {
    }

    @ApiModelProperty(name = "fmsFoodInfos", value = "食物信息集合", dataType = "List<List<FmsFoodInfo>>")
    private List<List<FmsFoodInfo>> fmsFoodInfos;

    public List<List<FmsFoodInfo>> getFmsFoodInfos() {
        return fmsFoodInfos;
    }

    public void setFmsFoodInfos(List<List<FmsFoodInfo>> fmsFoodInfos) {
        this.fmsFoodInfos = fmsFoodInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FmsFoodInfoVo that = (FmsFoodInfoVo) o;

        return Objects.equals(fmsFoodInfos, that.fmsFoodInfos);
    }

    @Override
    public int hashCode() {
        return fmsFoodInfos != null ? fmsFoodInfos.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FmsFoodInfoVo{" +
                "fmsFoodInfos=" + fmsFoodInfos +
                '}';
    }
}
