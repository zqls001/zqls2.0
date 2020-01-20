package com.duanxin.zqls.umps.dto;

import com.duanxin.zqls.common.dto.PageInfo;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/1/20 8:42
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAclPageInfo implements Serializable {
    private static final long serialVersionUID = -28022285727985654L;

    /**
     * 权限信息集合
     * */
    private List<UmsAclDto> umsAclDtos;

    /**
     * 分页信息
     * */
    private PageInfo pageInfo;
}
