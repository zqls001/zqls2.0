package com.duanxin.zqls.umps.dto;

import com.duanxin.zqls.common.dto.PageInfo;
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
     * 分页信息
     * */
    private PageInfo pageInfo;
}
