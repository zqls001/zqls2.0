package com.duanxin.zqls.ucenter.model;

import lombok.Builder;
import lombok.Data;
import org.joda.money.Money;

import java.io.Serializable;

/**
 * 用户账户表
 * ums_user_account_info
 * @author duanxin
 * @date 2019-09-21
 */
@Data
@Builder
public class UmsUserAccountInfo implements Serializable {

    private static final long serialVersionUID = -5865704025538221172L;
    /**
     * 用户账户id
     * id
     */
    private Integer id;

    /**
     * 用户帐号
     * aid
     */
    private String aid;

    /**
     * 账户余额
     * balance
     */
    private Money balance;

    /**
     * 流水类型：0消费流水，1充值流水
     * type
     */
    private String type;

    /**
     * 流水id：消费流水对应消费表id，充值流水对应充值表id
     * flow_id
     */
    private Integer flowId;
}