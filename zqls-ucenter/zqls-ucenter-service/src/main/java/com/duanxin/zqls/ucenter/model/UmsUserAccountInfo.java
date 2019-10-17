package com.duanxin.zqls.ucenter.model;

import com.duanxin.zqls.handler.MoneyTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.Money;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户账户表
 * ums_user_account_info
 * @author duanxin
 * @date 2019-09-21
 */
@Data
@Builder
@Table(name = "ums_user_account_info")
@AllArgsConstructor
@NoArgsConstructor
public class UmsUserAccountInfo implements Serializable {

    private static final long serialVersionUID = -5865704025538221172L;
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
    private String aid;

    /**
     * 账户余额
     * balance
     */
    @Column
    @ColumnType(
            jdbcType = JdbcType.BIGINT,
            typeHandler = MoneyTypeHandler.class
    )
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
}