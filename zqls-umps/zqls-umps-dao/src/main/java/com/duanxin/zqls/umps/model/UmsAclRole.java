package com.duanxin.zqls.umps.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限角色表
 * ums_acl_role
 * @author duanxin
 * @date 2019-12-08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "权限角色实体类")
public class UmsAclRole implements Serializable {

    private static final long serialVersionUID = -422605327202201785L;
    /**
     * 权限角色表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "权限角色主键id", dataType = "int", example = "1")
    private Integer id;

    /**
     * 权限id
     * aid
     */
    @Column
    @ApiModelProperty(name = "aid", value = "权限主键id", dataType = "int", example = "1")
    private Integer aid;

    /**
     * 角色id
     * rid
     */
    @Column
    @ApiModelProperty(name = "aid", value = "角色主键id", dataType = "int", example = "1")
    private Integer rid;

    /**
     * 最后一次操作时间
     * operate_time
     */
    @Column
    private Date operateTime;

    /**
     * 操作者ip
     * operate_ip
     */
    @Column
    private String operateIp;

    /**
     * 操作者
     * operator
     */
    @Column
    private String operator;
}