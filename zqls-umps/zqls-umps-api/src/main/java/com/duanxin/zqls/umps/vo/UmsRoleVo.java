package com.duanxin.zqls.umps.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * role view object
 * @author duanxin
 * @version 1.0
 * @date 2020/1/15 9:56
 */
@Getter
@Setter
@Builder
@ApiModel(description = "角色实体类")
public class UmsRoleVo implements Serializable {
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
}
