package com.duanxin.zqls.ucenter.dto;


import com.duanxin.zqls.common.dto.PageInfo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/3/27 10:14
 */
public class UmsUserPageInfo implements Serializable {
    public UmsUserPageInfo() {
    }

    private static final long serialVersionUID = 2931011518346106261L;

    private List<UmsUserInfoDto> umsUserInfoDtos;

    private PageInfo pageInfo;

    public List<UmsUserInfoDto> getUmsUserInfoDtos() {
        return umsUserInfoDtos;
    }

    public void setUmsUserInfoDtos(List<UmsUserInfoDto> umsUserInfoDtos) {
        this.umsUserInfoDtos = umsUserInfoDtos;
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

        UmsUserPageInfo that = (UmsUserPageInfo) o;

        if (!Objects.equals(umsUserInfoDtos, that.umsUserInfoDtos)) {
            return false;
        }
        return Objects.equals(pageInfo, that.pageInfo);
    }

    @Override
    public int hashCode() {
        int result = umsUserInfoDtos != null ? umsUserInfoDtos.hashCode() : 0;
        result = 31 * result + (pageInfo != null ? pageInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsUserPageInfo{" +
                "umsUserInfoDtos=" + umsUserInfoDtos +
                ", pageInfo=" + pageInfo +
                '}';
    }
}
