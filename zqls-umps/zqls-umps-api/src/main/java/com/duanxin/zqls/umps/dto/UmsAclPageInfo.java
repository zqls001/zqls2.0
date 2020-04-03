package com.duanxin.zqls.umps.dto;

import com.duanxin.zqls.common.dto.PageInfo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/1/20 8:42
 */
public class UmsAclPageInfo implements Serializable {

    public UmsAclPageInfo() {
    }

    private static final long serialVersionUID = -28022285727985654L;

    /**
     * 权限信息集合
     * */
    private List<UmsAclDto> umsAclDtos;

    /**
     * 分页信息
     * */
    private PageInfo pageInfo;

    public List<UmsAclDto> getUmsAclDtos() {
        return umsAclDtos;
    }

    public void setUmsAclDtos(List<UmsAclDto> umsAclDtos) {
        this.umsAclDtos = umsAclDtos;
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

        UmsAclPageInfo that = (UmsAclPageInfo) o;

        if (!Objects.equals(umsAclDtos, that.umsAclDtos)) {
            return false;
        }
        return Objects.equals(pageInfo, that.pageInfo);
    }

    @Override
    public int hashCode() {
        int result = umsAclDtos != null ? umsAclDtos.hashCode() : 0;
        result = 31 * result + (pageInfo != null ? pageInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsAclPageInfo{" +
                "umsAclDtos=" + umsAclDtos +
                ", pageInfo=" + pageInfo +
                '}';
    }
}
