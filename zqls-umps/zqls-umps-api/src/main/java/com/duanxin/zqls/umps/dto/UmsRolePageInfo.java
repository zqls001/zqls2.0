package com.duanxin.zqls.umps.dto;

import com.duanxin.zqls.common.dto.PageInfo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 8:53
 */
public class UmsRolePageInfo implements Serializable {

    public UmsRolePageInfo() {
    }

    private static final long serialVersionUID = 5423340849480361982L;

    /**
     * 数据集合
     * */
    private List<UmsRoleDto> umsRoleDtos;

    /**
     * 分页信息
     * */
    private PageInfo pageInfo;

    public List<UmsRoleDto> getUmsRoleDtos() {
        return umsRoleDtos;
    }

    public void setUmsRoleDtos(List<UmsRoleDto> umsRoleDtos) {
        this.umsRoleDtos = umsRoleDtos;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsRolePageInfo that = (UmsRolePageInfo) o;

        if (!Objects.equals(umsRoleDtos, that.umsRoleDtos)) {
            return false;
        }
        return Objects.equals(pageInfo, that.pageInfo);
    }

    @Override
    public int hashCode() {
        int result = umsRoleDtos != null ? umsRoleDtos.hashCode() : 0;
        result = 31 * result + (pageInfo != null ? pageInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsRolePageInfo{" +
                "umsRoleDtos=" + umsRoleDtos +
                ", pageInfo=" + pageInfo +
                '}';
    }
}
