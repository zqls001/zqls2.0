package com.duanxin.zqls.ucenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 用户账户表
 * ums_user_account_info
 * @author duanxin
 * @date 2019-12-03
 */
@ApiModel(description = "用户账户基本信息实体类")
public class UmsUserAccountInfo implements Serializable {

    public UmsUserAccountInfo() {
    }

    private static final long serialVersionUID = -4227749794197442690L;
    /**
     * 用Id户id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "用户账户信息主键id",
            dataType = "int", required = true, example = "1")
    private Integer id;

    /**
     * 用户帐号
     * aid
     */
    @Column
    @ApiModelProperty(name = "aid", value = "用户账户号",
            dataType = "int", required = true, example = "200000001")
    private Integer aid;

    /**
     * 账户余额，单位（元）
     * balance
     */
    @Column
    @ApiModelProperty(name = "balance", value = "用户账户余额，单位（元）",
            dataType = "BigDecimal", required = true, example = "100.00")
    private BigDecimal balance;

    /**
     * 流水类型：0消费流水，1充值流水
     * type
     */
    @Column
    @ApiModelProperty(name = "type", value = "用户账户流水id", notes = "流水类型：0消费流水，1充值流水",
            dataType = "String", required = true, example = "0")
    private String type;

    /**
     * 流水id：消费流水对应消费表id，充值流水对应充值表id
     * flow_id
     */
    @Column
    @ApiModelProperty(name = "flowId", value = "流水id", notes = "流水id：消费流水对应消费表id，充值流水对于充值表id",
            dataType = "int", required = true, example = "1")
    private Integer flowId;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "用户账户信息创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    @ApiModelProperty(name = "renewTime", value = "用户账户信息更新时间", notes = "当用户信息更改之后，该属性就进行更新",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date renewTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getRenewTime() {
        return renewTime;
    }

    public void setRenewTime(Date renewTime) {
        this.renewTime = renewTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsUserAccountInfo that = (UmsUserAccountInfo) o;

        if (!Objects.equals(id, that.id)) {
            return false;
        }
        if (!Objects.equals(aid, that.aid)) {
            return false;
        }
        if (!Objects.equals(balance, that.balance)) {
            return false;
        }
        if (!Objects.equals(type, that.type)) {
            return false;
        }
        if (!Objects.equals(flowId, that.flowId)) {
            return false;
        }
        if (!Objects.equals(createTime, that.createTime)) {
            return false;
        }
        return Objects.equals(renewTime, that.renewTime);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (aid != null ? aid.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (flowId != null ? flowId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (renewTime != null ? renewTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsUserAccountInfo{" +
                "id=" + id +
                ", aid=" + aid +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                ", flowId=" + flowId +
                ", createTime=" + createTime +
                ", renewTime=" + renewTime +
                '}';
    }
}