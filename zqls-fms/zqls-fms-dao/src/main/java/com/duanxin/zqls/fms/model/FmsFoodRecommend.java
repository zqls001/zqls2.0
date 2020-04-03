package com.duanxin.zqls.fms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 食物推荐表
 * fms_food_recommend
 * @author duanxin
 * @date 2019-12-03
 */
@ApiModel(description = "食物推荐实体类")
public class FmsFoodRecommend implements Serializable {

    private static final long serialVersionUID = -1468433155597044696L;

    public FmsFoodRecommend() {
    }

    /**
     * 食物推荐表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "食物推荐表主键id",
            dataType = "int", required = true, example = "1")
    private Integer id;

    /**
     * 用户id
     * uid
     */
    @Column
    @ApiModelProperty(name = "uid", value = "用户主键id",
            dataType = "int", required = true, example = "1")
    private Integer uid;

    /**
     * 食物id
     * fid
     */
    @Column
    @ApiModelProperty(name = "fid", value = "食物主键id",
            dataType = "int", required = true, example = "1")
    private Integer fid;

    /**
     * 类型：0喜好菜品推荐，1膳食推荐
     * type
     */
    @Column
    @ApiModelProperty(name = "id", value = "食物推荐类型：0喜好菜品推荐，1膳食推荐",
            dataType = "int", required = true, example = "1")
    private Byte type;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "食物推荐创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    @ApiModelProperty(name = "renewTime", value = "食物推荐更新时间", notes = "当该条记录更改后，该字段将自动更新",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date renewTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

        FmsFoodRecommend that = (FmsFoodRecommend) o;

        if (!id.equals(that.id)) {
            return false;
        }
        if (!uid.equals(that.uid)) {
            return false;
        }
        if (!fid.equals(that.fid)) {
            return false;
        }
        if (!type.equals(that.type)) {
            return false;
        }
        if (!createTime.equals(that.createTime)) {
            return false;
        }
        return renewTime.equals(that.renewTime);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + uid.hashCode();
        result = 31 * result + fid.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + createTime.hashCode();
        result = 31 * result + renewTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FmsFoodRecommend{" +
                "id=" + id +
                ", uid=" + uid +
                ", fid=" + fid +
                ", type=" + type +
                ", createTime=" + createTime +
                ", renewTime=" + renewTime +
                '}';
    }
}