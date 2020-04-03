package com.duanxin.zqls.umps.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 权限角色表
 * ums_acl_role
 * @author duanxin
 * @date 2019-12-08
 */
@ApiModel(description = "权限角色实体类")
public class UmsAclRole implements Serializable {

    public UmsAclRole() {
    }

    private static final long serialVersionUID = -422605327202201785L;
    /**
     * 权限角色表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "权限角色主键id", dataType = "int", example = "1")
    private Integer id;

    /**
     * 权限id
     * aid
     */
    @Column
    @ApiModelProperty(name = "aid", value = "权限主键id", dataType = "int", example = "1")
    private Integer aid;

    /**
     * 角色id
     * rid
     */
    @Column
    @ApiModelProperty(name = "aid", value = "角色主键id", dataType = "int", example = "1")
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

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

        UmsAclRole that = (UmsAclRole) o;

        if (!Objects.equals(id, that.id)) {
            return false;
        }
        if (!Objects.equals(aid, that.aid)) {
            return false;
        }
        if (!Objects.equals(rid, that.rid)) {
            return false;
        }
        if (!Objects.equals(operateTime, that.operateTime)) {
            return false;
        }
        if (!Objects.equals(operateIp, that.operateIp)) {
            return false;
        }
        return Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (aid != null ? aid.hashCode() : 0);
        result = 31 * result + (rid != null ? rid.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (operateIp != null ? operateIp.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsAclRole{" +
                "id=" + id +
                ", aid=" + aid +
                ", rid=" + rid +
                ", operateTime=" + operateTime +
                ", operateIp='" + operateIp + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}