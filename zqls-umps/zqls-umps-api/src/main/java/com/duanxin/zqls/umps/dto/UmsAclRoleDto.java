package com.duanxin.zqls.umps.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 权限角色数据传输对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/30 8:48
 */
public class UmsAclRoleDto implements Serializable {

    public UmsAclRoleDto() {
    }

    private static final long serialVersionUID = -6784375400899689495L;

    private UmsRoleDto umsRoleDto;

    private List<UmsAclDto> umsAclDtos;

    public UmsRoleDto getUmsRoleDto() {
        return umsRoleDto;
    }

    public void setUmsRoleDto(UmsRoleDto umsRoleDto) {
        this.umsRoleDto = umsRoleDto;
    }

    public List<UmsAclDto> getUmsAclDtos() {
        return umsAclDtos;
    }

    public void setUmsAclDtos(List<UmsAclDto> umsAclDtos) {
        this.umsAclDtos = umsAclDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsAclRoleDto that = (UmsAclRoleDto) o;

        if (!Objects.equals(umsRoleDto, that.umsRoleDto)) {
            return false;
        }
        return Objects.equals(umsAclDtos, that.umsAclDtos);
    }

    @Override
    public int hashCode() {
        int result = umsRoleDto != null ? umsRoleDto.hashCode() : 0;
        result = 31 * result + (umsAclDtos != null ? umsAclDtos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsAclRoleDto{" +
                "umsRoleDto=" + umsRoleDto +
                ", umsAclDtos=" + umsAclDtos +
                '}';
    }
}
