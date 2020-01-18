package com.duanxin.zqls.umps.model;

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
 * 权限表
 * ums_acl
 * @author duanxin
 * @date 2019-12-08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UmsAcl implements Serializable {

    private static final long serialVersionUID = -5328984846136988590L;
    /**
     * 权限表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限码
     * code
     */
    @Column
    private String code;

    /**
     * 权限名称
     * name
     */
    @Column
    private String name;

    /**
     * 请求url
     * url
     */
    @Column
    private String url;

    /**
     * 类型：0按钮，1菜单，2其他
     * type
     */
    @Column
    private Byte type;

    /**
     * 状态：0正常，1冻结
     * status
     */
    @Column
    private Byte status;

    /**
     * 权限备注
     * remark
     */
    @Column
    private String remark;

    /**
     * 最后一时间
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