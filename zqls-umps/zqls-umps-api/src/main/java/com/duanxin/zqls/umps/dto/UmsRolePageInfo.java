package com.duanxin.zqls.umps.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 8:53
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsRolePageInfo implements Serializable {
    private static final long serialVersionUID = 5423340849480361982L;

    /**
     * 数据集合
     * */
    private List<UmsRoleDto> umsRoleDtos;

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
