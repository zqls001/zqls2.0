package com.duanxin.zqls.umps.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * role view object
 * @author duanxin
 * @version 1.0
 * @date 2020/1/15 9:56
 */
@ApiModel(description = "角色实体类")
public class UmsRoleVo implements Serializable {

    public UmsRoleVo() {
    }

    private static final long serialVersionUID = -401602594464764121L;

    @ApiModelProperty(name = "name", value = "角色名称",
            dataType = "String", example = "root", required = true)
    private String name;

    @ApiModelProperty(name = "type", value = "角色类型:0管理员，1其他",
            dataType = "int", example = "0", required = true)
    private Byte type;

    @ApiModelProperty(name = "status", value = "角色状态：0正常，1异常",
            dataType = "int", example = "0")
    private Byte status;

    @ApiModelProperty(name = "remark", value = "角色描述信息", dataType = "String")
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsRoleVo umsRoleVo = (UmsRoleVo) o;

        if (!Objects.equals(name, umsRoleVo.name)) {
            return false;
        }
        if (!Objects.equals(type, umsRoleVo.type)) {
            return false;
        }
        if (!Objects.equals(status, umsRoleVo.status)) {
            return false;
        }
        return Objects.equals(remark, umsRoleVo.remark);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsRoleVo{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }
}
