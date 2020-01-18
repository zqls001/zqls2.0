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
 * 角色表
 * ums_role
 * @author duanxin
 * @date 2019-12-08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsRole implements Serializable {

    private static final long serialVersionUID = 395921382792122197L;
    /**
     * 角色表id
     * id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    /**
     * 角色名称
     * name
     */
    @Column
    private String name;

    /**
     * 类型：0管理员，1其他
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
     * 角色备注
     * remark
     */
    @Column
    private String remark;

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