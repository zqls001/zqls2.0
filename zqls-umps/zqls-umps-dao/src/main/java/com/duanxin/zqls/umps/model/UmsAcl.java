package com.duanxin.zqls.umps.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 权限表
 * ums_acl
 * @author duanxin
 * @date 2019-12-08
 */
public class UmsAcl implements Serializable {

    public UmsAcl() {
    }

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
     * 请求类型：0GET， 1POST， 2DELETE， 3PUT
     * */
    @Column
    private Integer requestType;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
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

        UmsAcl umsAcl = (UmsAcl) o;

        if (!Objects.equals(id, umsAcl.id)) {
            return false;
        }
        if (!Objects.equals(code, umsAcl.code)) {
            return false;
        }
        if (!Objects.equals(name, umsAcl.name)) {
            return false;
        }
        if (!Objects.equals(url, umsAcl.url)) {
            return false;
        }
        if (!Objects.equals(requestType, umsAcl.requestType)) {
            return false;
        }
        if (!Objects.equals(type, umsAcl.type)) {
            return false;
        }
        if (!Objects.equals(status, umsAcl.status)) {
            return false;
        }
        if (!Objects.equals(remark, umsAcl.remark)) {
            return false;
        }
        if (!Objects.equals(operateTime, umsAcl.operateTime)) {
            return false;
        }
        if (!Objects.equals(operateIp, umsAcl.operateIp)) {
            return false;
        }
        return Objects.equals(operator, umsAcl.operator);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (requestType != null ? requestType.hashCode() : 0);
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
        return "UmsAcl{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", requestType=" + requestType +
                ", type=" + type +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", operateTime=" + operateTime +
                ", operateIp='" + operateIp + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}