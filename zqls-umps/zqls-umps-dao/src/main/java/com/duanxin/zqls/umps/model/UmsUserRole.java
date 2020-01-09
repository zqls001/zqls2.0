package com.duanxin.zqls.umps.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UmsUserRole implements Serializable {

    private static final long serialVersionUID = 8790019443892236791L;
    /**
     * 用户角色表id
     * id
     */
    private Integer id;

    /**
     * 用户id
     * uid
     */
    private Integer uid;

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