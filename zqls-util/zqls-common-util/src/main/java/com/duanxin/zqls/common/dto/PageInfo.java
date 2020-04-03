package com.duanxin.zqls.common.dto;

import java.io.Serializable;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/1/20 8:44
 */
public class PageInfo implements Serializable {
    private static final long serialVersionUID = 2647754818700213506L;

    public PageInfo() {
    }

    /**
     * 总记录数
     * */
    private Long totalCount;

    /**
     * 当前页码
     * */
    private Integer pageNo;

    /**
     * 每页大小
     * */
    private Integer pageSize;

    /**
     * 总页数
     * */
    private Integer totalPage;

    /**
     * 前一页
     * */
    private Integer prePage;

    /**
     * 后一页
     * */
    private Integer nextPage;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PageInfo pageInfo = (PageInfo) o;

        if (!totalCount.equals(pageInfo.totalCount)) {
            return false;
        }
        if (!pageNo.equals(pageInfo.pageNo)) {
            return false;
        }
        if (!pageSize.equals(pageInfo.pageSize)) {
            return false;
        }
        if (!totalPage.equals(pageInfo.totalPage)) {
            return false;
        }
        if (!prePage.equals(pageInfo.prePage)) {
            return false;
        }
        return nextPage.equals(pageInfo.nextPage);
    }

    @Override
    public int hashCode() {
        int result = totalCount.hashCode();
        result = 31 * result + pageNo.hashCode();
        result = 31 * result + pageSize.hashCode();
        result = 31 * result + totalPage.hashCode();
        result = 31 * result + prePage.hashCode();
        result = 31 * result + nextPage.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "totalCount=" + totalCount +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                '}';
    }
}
