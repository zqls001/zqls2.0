package com.duanxin.zqls.common.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/1/20 8:44
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageInfo implements Serializable {
    private static final long serialVersionUID = 2647754818700213506L;

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
}
