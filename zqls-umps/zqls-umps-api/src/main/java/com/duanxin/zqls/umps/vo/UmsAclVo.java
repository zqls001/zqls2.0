package com.duanxin.zqls.umps.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * acl view object
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 8:31
 */
@ApiModel(description = "权限实体类")
public class UmsAclVo implements Serializable {

    public UmsAclVo() {
    }

    private static final long serialVersionUID = 3431432125680522269L;

    @ApiModelProperty(name = "code", value = "权限码", dataType = "String", example = "001")
    private String code;

    @ApiModelProperty(name = "name", value = "权限名称", dataType = "String", example = "删除权限")
    private String name;

    @ApiModelProperty(name = "url", value = "请求url", dataType = "String", example = "http:127.0.0.1:8071/UmsUser/getAll")
    private String url;

    @ApiModelProperty(name = "requestType", value = "请求类型：0GET， 1POST， 2DELETE， 3PUT", dataType = "int", example = "0")
    private Integer requestType;

    @ApiModelProperty(name ="type", value = "权限类型：0按钮，1菜单，2其他", dataType = "int", example = "0")
    private Byte type;

    @ApiModelProperty(name = "status", value = "权限状态：0正常，1冻结", dataType = "int", example = "0")
    private Byte status;

    @ApiModelProperty(name = "remark", value = "权限备注", dataType = "String", example = "该权限用于删除")
    private String remark;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsAclVo umsAclVo = (UmsAclVo) o;

        if (!Objects.equals(code, umsAclVo.code)) {
            return false;
        }
        if (!Objects.equals(name, umsAclVo.name)) {
            return false;
        }
        if (!Objects.equals(url, umsAclVo.url)) {
            return false;
        }
        if (!Objects.equals(requestType, umsAclVo.requestType)){
            return false;
        }
        if (!Objects.equals(type, umsAclVo.type)) {
            return false;
        }
        if (!Objects.equals(status, umsAclVo.status)) {
            return false;
        }
        return Objects.equals(remark, umsAclVo.remark);
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
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
        return "UmsAclVo{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", requestType=" + requestType +
                ", type=" + type +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }
}
