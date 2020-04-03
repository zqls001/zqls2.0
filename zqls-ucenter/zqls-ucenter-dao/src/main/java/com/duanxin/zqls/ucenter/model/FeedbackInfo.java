package com.duanxin.zqls.ucenter.model;

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
 * 反馈基本表
 * feedback_info
 * @author duanxin
 * @date 2019-12-08
 */
@ApiModel(description = "用户反馈信息实体类")
public class FeedbackInfo implements Serializable {

    public FeedbackInfo() {
    }

    private static final long serialVersionUID = -6280699464210391587L;
    /**
     * 反馈表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "用户反馈信息主键id", dataType = "int", example = "1")
    private Integer id;

    /**
     * 用户id
     * uid
     */
    @Column
    @ApiModelProperty(name = "uid", value = "用户学工号",
            dataType = "String", example = "10200001")
    private String uid;

    /**
     * 反馈类型：0食物，1食堂环境，2系统改进，3其他
     * type
     */
    @Column
    @ApiModelProperty(name = "type", value = "用户反馈信息类型：0食物，1食堂环境，2系统改进，3其他",
            dataType = "int", example = "1")
    private Byte type;

    /**
     * 反馈描述
     * remark
     */
    @Column
    @ApiModelProperty(name = "remark", value = "用户反馈信息描述",
            dataType = "String", example = "描述：xxx食物中存在xxx问题")
    private String remark;

    /**
     * 状态：0未查看，1已查看，2已解决
     * status
     */
    @Column
    @ApiModelProperty(name = "status", value = "用户反馈信息所处的状态：0未查看，1已查看，2已解决",
            dataType = "int", example = "1")
    private Byte status;

    /**
     * 是否有图片：0无，1有
     * is_pic
     */
    @Column
    @ApiModelProperty(name = "isPic", value = "用户反馈信息是否有图片:0无，1有",
            dataType = "int", example = "1")
    private Byte isPic;

    /**
     * 图片url地址
     * pic_url
     */
    @Column
    @ApiModelProperty(name = "picUrl", value = "用户反馈信息相关图片地址", dataType = "String", example = "http://39.120.106.154/A/E/C/S/E/A/S/uuid.jpg")
    private String picUrl;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "用户反馈信息创建时间",
            dataType = "Date", example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    @ApiModelProperty(name = "renewTime", value = "该记录只要更改，该字段就进行更新",
            dataType = "Date", example = "2019-12-06 08：53：01")
    private Date renewTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIsPic() {
        return isPic;
    }

    public void setIsPic(Byte isPic) {
        this.isPic = isPic;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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

        FeedbackInfo that = (FeedbackInfo) o;

        if (!Objects.equals(id, that.id)) {
            return false;
        }
        if (!Objects.equals(uid, that.uid)) {
            return false;
        }
        if (!Objects.equals(type, that.type)) {
            return false;
        }
        if (!Objects.equals(remark, that.remark)) {
            return false;
        }
        if (!Objects.equals(status, that.status)) {
            return false;
        }
        if (!Objects.equals(isPic, that.isPic)) {
            return false;
        }
        if (!Objects.equals(picUrl, that.picUrl)) {
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
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isPic != null ? isPic.hashCode() : 0);
        result = 31 * result + (picUrl != null ? picUrl.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (renewTime != null ? renewTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FeedbackInfo{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", type=" + type +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", isPic=" + isPic +
                ", picUrl='" + picUrl + '\'' +
                ", createTime=" + createTime +
                ", renewTime=" + renewTime +
                '}';
    }
}