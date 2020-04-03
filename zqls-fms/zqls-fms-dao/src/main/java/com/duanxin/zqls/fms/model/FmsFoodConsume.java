package com.duanxin.zqls.fms.model;

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
 * 食物消耗表
 * fms_food_consume
 * @author duanxin
 * @date 2019-12-03
 */
@ApiModel(description = "食物消耗实体类")
public class FmsFoodConsume implements Serializable {

    private static final long serialVersionUID = 2384422348050562530L;

    public FmsFoodConsume() {
    }

    /**
     * 食物Id表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "食物消耗主键id",
            dataType = "int", required = true, example = "1")
    private Integer id;

    /**
     * 食物id
     * fid
     */
    @Column
    @ApiModelProperty(name = "fid", value = "食物主键id",
            dataType = "int", required = true, example = "1")
    private Integer fid;

    /**
     * 用户工号
     * uid
     */
    @Column
    @ApiModelProperty(name = "uid", value = "用户学工号",
            dataType = "String", required = true, example = "10200001")
    private String uid;

    /**
     * 食物质量
     * food_quality
     */
    @Column
    @ApiModelProperty(name = "foodQuality", value = "食物消耗的质量，单位（克）",
            dataType = "BigDecimal", required = true, example = "100.12")
    private BigDecimal foodQuality;

    /**
     * 类型：0早，1中，2晚
     * type
     */
    @Column
    @ApiModelProperty(name = "type", value = "用户用餐所在时间段：0早，1中，2晚",
            dataType = "int", required = true, example = "1")
    private Byte type;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "用户消费创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    @ApiModelProperty(name = "renewTime", value = "用户消耗更新时间", notes = "当该条记录更改后，该字段将自动更新",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date renewTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public BigDecimal getFoodQuality() {
        return foodQuality;
    }

    public void setFoodQuality(BigDecimal foodQuality) {
        this.foodQuality = foodQuality;
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

        FmsFoodConsume that = (FmsFoodConsume) o;

        if (!Objects.equals(id, that.id)) {
            return false;
        }
        if (!Objects.equals(fid, that.fid)) {
            return false;
        }
        if (!Objects.equals(uid, that.uid)) {
            return false;
        }
        if (!Objects.equals(foodQuality, that.foodQuality)) {
            return false;
        }
        if (!Objects.equals(type, that.type)) {
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
        result = 31 * result + (fid != null ? fid.hashCode() : 0);
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (foodQuality != null ? foodQuality.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (renewTime != null ? renewTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FmsFoodConsume{" +
                "id=" + id +
                ", fid=" + fid +
                ", uid='" + uid + '\'' +
                ", foodQuality=" + foodQuality +
                ", type=" + type +
                ", createTime=" + createTime +
                ", renewTime=" + renewTime +
                '}';
    }
}