package com.duanxin.zqls.umps.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UmsAclRole implements Serializable {

    private static final long serialVersionUID = -422605327202201785L;
    /**
     * 权限角色表id
     * id
     */
    private Integer id;

    /**
     * 权限id
     * aid
     */
    private Integer aid;

    /**
     * 角色id
     * rid
     */
    private Integer rid;

    /**
     * 最后一次操作时间
     * operate_time
     */
    private Date operateTime;

    /**
     * 操作者ip
     * operate_ip
     */
    private String operateIp;

    /**
     * 操作者
     * operator
     */
    private String operator;
}