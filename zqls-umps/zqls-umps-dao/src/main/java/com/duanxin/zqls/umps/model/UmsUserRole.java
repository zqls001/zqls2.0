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
 * 用户角色表
 * ums_user_role
 * @author duanxin
 * @date 2019-12-08
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ApiModel(description = "用户角色表")
public class UmsUserRole implements Serializable {

    private static final long serialVersionUID = 8790019443892236791L;
    /**
     * 用户角色表id
     * id
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "用户角色主键id", dataType = "int", example = "1")
    private Integer id;

    /**
     * 用户id
     * uid
     */
    @Column
    @ApiModelProperty(name = "uid", value = "用户主键id", dataType = "int", example = "1")
    private Integer uid;

    /**
     * 角色i
     * rid
     */
    @Column
    @ApiModelProperty(name = "rid", value = "角色主键id", dataType = "int", example = "1")
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