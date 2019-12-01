package com.duanxin.test.model;

import com.duanxin.zqls.common.handler.MoneyTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.Money;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户账户表
 * ums_user_account_info
 * @author duanxin
 * @date 2019-11-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsUserAccountInfo implements Serializable {

    private static final long serialVersionUID = 9055613626306508799L;
    /**
     * 用户账户id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户帐号
     * aid
     */
    @Column
    private Integer aid;

    /**
     * 账户余额
     * balance
     */
    @Column
    @ColumnType(jdbcType = JdbcType.BIGINT, typeHandler = MoneyTypeHandler.class)
    private Money balance;

    /**
     * 流水类型：0消费流水，1充值流水
     * type
     */
    @Column
    private String type;

    /**
     * 流水id：消费流水对应消费表id，充值流水对应充值表id
     * flow_id
     */
    @Column
    private Integer flowId;

    /**
     * 创建时间
     * create_time
     */
    @Column
    private Date createTime;

    /**
     * 更新时间

     * renew_time
     */
    @Column
    private Date renewTime;

}