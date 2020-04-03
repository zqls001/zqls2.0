package com.duanxin.zqls.umps.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 角色表
 * ums_role
 * @author duanxin
 * @date 2019-12-08
 */
public class UmsRole implements Serializable {

    public UmsRole() {
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsRole umsRole = (UmsRole) o;

        if (!Objects.equals(id, umsRole.id)) {
            return false;
        }
        if (!Objects.equals(name, umsRole.name)) {
            return false;
        }
        if (!Objects.equals(type, umsRole.type)) {
            return false;
        }
        if (!Objects.equals(status, umsRole.status)) {
            return false;
        }
        if (!Objects.equals(remark, umsRole.remark)) {
            return false;
        }
        if (!Objects.equals(operateTime, umsRole.operateTime)) {
            return false;
        }
        if (!Objects.equals(operateIp, umsRole.operateIp)) {
            return false;
        }
        return Objects.equals(operator, umsRole.operator);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (operateIp != null ? operateIp.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", operateTime=" + operateTime +
                ", operateIp='" + operateIp + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}