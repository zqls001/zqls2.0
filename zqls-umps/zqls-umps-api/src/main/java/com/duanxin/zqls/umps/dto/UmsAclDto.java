package com.duanxin.zqls.umps.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * 权限数据输出对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 9:19
 */
public class UmsAclDto implements Serializable {

    public UmsAclDto() {
    }

    private static final long serialVersionUID = 4211713956017479973L;

    private Integer id;

    private String code;

    private String name;

    private String url;

    private String requestType;

    private Byte type;

    private Byte status;

    private String remark;

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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsAclDto umsAclDto = (UmsAclDto) o;

        if (!Objects.equals(id, umsAclDto.id)) {
            return false;
        }
        if (!Objects.equals(code, umsAclDto.code)) {
            return false;
        }
        if (!Objects.equals(name, umsAclDto.name)) {
            return false;
        }
        if (!Objects.equals(url, umsAclDto.url)) {
            return false;
        }
        if (!Objects.equals(requestType, umsAclDto.requestType)) {
            return false;
        }
        if (!Objects.equals(type, umsAclDto.type)) {
            return false;
        }
        if (!Objects.equals(status, umsAclDto.status)) {
            return false;
        }
        return Objects.equals(remark, umsAclDto.remark);
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
        return result;
    }

    @Override
    public String toString() {
        return "UmsAclDto{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", requestType='" + requestType + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }
}
