package com.duanxin.zqls.umps.dto;

import com.duanxin.zqls.ucenter.dto.UmsUserInfoDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 角色用户数据传输对象
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:07
 */
public class UmsUserRoleDto implements Serializable {

    public UmsUserRoleDto() {
    }

    private static final long serialVersionUID = 4826002802349144805L;

    private UmsRoleDto umsRoleDto;

    private List<UmsUserInfoDto> umsUserInfoDtos;

    public UmsRoleDto getUmsRoleDto() {
        return umsRoleDto;
    }

    public void setUmsRoleDto(UmsRoleDto umsRoleDto) {
        this.umsRoleDto = umsRoleDto;
    }

    public List<UmsUserInfoDto> getUmsUserInfoDtos() {
        return umsUserInfoDtos;
    }

    public void setUmsUserInfoDtos(List<UmsUserInfoDto> umsUserInfoDtos) {
        this.umsUserInfoDtos = umsUserInfoDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsUserRoleDto that = (UmsUserRoleDto) o;

        if (!Objects.equals(umsRoleDto, that.umsRoleDto)) {
            return false;
        }
        return Objects.equals(umsUserInfoDtos, that.umsUserInfoDtos);
    }

    @Override
    public int hashCode() {
        int result = umsRoleDto != null ? umsRoleDto.hashCode() : 0;
        result = 31 * result + (umsUserInfoDtos != null ? umsUserInfoDtos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsUserRoleDto{" +
                "umsRoleDto=" + umsRoleDto +
                ", umsUserInfoDtos=" + umsUserInfoDtos +
                '}';
    }
}
