package com.duanxin.zqls.umps.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 权限角色数据传输对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/30 8:48
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAclRoleDto implements Serializable {
    private static final long serialVersionUID = -6784375400899689495L;

    private UmsRoleDto umsRoleDto;

    private List<UmsAclDto> umsAclDtos;
}
