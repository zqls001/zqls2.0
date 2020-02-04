package com.duanxin.zqls.umps.dto;

import com.duanxin.zqls.ucenter.dto.UmsUserInfoDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 角色用户数据传输对象
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:07
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsUserRoleDto implements Serializable {
    private static final long serialVersionUID = 4826002802349144805L;

    private UmsRoleDto umsRoleDto;

    private List<UmsUserInfoDto> umsUserInfoDtos;
}
