package com.duanxin.zqls.umps.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * acl view object
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 8:31
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "权限实体类")
public class UmsAclVo implements Serializable {
    private static final long serialVersionUID = 3431432125680522269L;

    @ApiModelProperty(name = "code", value = "权限码", dataType = "String", example = "001")
    private String code;

    @ApiModelProperty(name = "name", value = "权限名称", dataType = "String", example = "删除权限")
    private String name;

    @ApiModelProperty(name = "url", value = "请求url", dataType = "String", example = "http:127.0.0.1:8071/UmsUser/getAll")
    private String url;

    @ApiModelProperty(name ="type", value = "权限类型：0按钮，1菜单，2其他", dataType = "int", example = "0")
    private Byte type;

    @ApiModelProperty(name = "status", value = "权限状态：0正常，1冻结", dataType = "int", example = "0")
    private Byte status;

    @ApiModelProperty(name = "remark", value = "权限备注", dataType = "String", example = "该权限用于删除")
    private String remark;
}
