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

/**
 * 食物基本信息表
 * fms_food_info
 * @author duanxin
 * @date 2019-12-03
 */
@ApiModel(description = "食物基本信息实体类")
public class FmsFoodInfo implements Serializable {

    private static final long serialVersionUID = 943459489691908864L;

    public FmsFoodInfo() {
    }

    /**
     * 食物基本表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "食物基本信息主键id",
            dataType = "int", required = true, example = "1")
    private Integer id;

    /**
     * 食物名称
     * name
     */
    @Column
    @ApiModelProperty(name = "name", value = "食物名称",
            dataType = "String", required = true, example = "小鸡炖蘑菇")
    private String name;

    /**
     * 食物价格，单位（克/元）
     * price
     */
    @Column
    @ApiModelProperty(name = "price", value = "食物价格，单位（克/元）",
            dataType = "BigDecimal", required = true, example = "0.01")
    private BigDecimal price;

    /**
     * 食物备注
     * remark
     */
    @Column
    @ApiModelProperty(name = "remark", value = "食物描述",
            dataType = "String", example = "小鸡炖蘑菇：味道鲜美，营养丰富")
    private String remark;

    /**
     * 口味类型：0酸，1甜，2苦，3辣，4香，5咸
     * taste_type
     */
    @Column
    @ApiModelProperty(name = "tasteType", value = "食物口味：0酸，1甜，2苦，3辣，4香，5咸",
            dataType = "int", required = true, example = "5")
    private Byte tasteType;

    /**
     * 基本特征：0葱，1蒜，2姜，3香菜，4其他
     * basic_features
     */
    @Column
    @ApiModelProperty(name = "basicFeatures", value = "食物基本特征：0葱，1蒜，2姜，3香菜，4其他",
            dataType = "int", required = true, example = "4")
    private Byte basicFeatures;

    /**
     * 状态：0正常，1冻结
     * status
     */
    @Column
    @ApiModelProperty(name = "status", value = "食物状态：0正常，1冻结",
            dataType = "int", required = true, example = "0")
    private Byte status;

    /**
     * 图片地址
     * pic_url
     */
    @Column
    @ApiModelProperty(name = "picUrl", value = "食物图片地址",
            dataType = "String", example = "http://39.120.106.154/A/E/C/S/E/A/S/xiaojidunmogu.jpg")
    private String picUrl;

    /**
     * 所在地点
     * place
     */
    @Column
    @ApiModelProperty(name = "place", value = "食物所在地方",
            dataType = "String", required = true, example = "和畅")
    private String place;

    /**
     * 类型：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类
     * type
     */
    @Column
    @ApiModelProperty(name = "type", value = "食物类型：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类",
            dataType = "int", required = true, example = "0")
    private Byte type;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "食物创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 最后一次操作时间
     * operate_time
     */
    @Column
    @ApiModelProperty(name = "operateTime", value = "食物更新时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date operateTime;

    /**
     * 操作者ip
     * operate_ip
     */
    @Column
    @ApiModelProperty(name = "operateIp", value = "管理员操作ip地址",
            dataType = "String", required = true, example = "0.0.0.0")
    private String operateIp;

    /**
     * 操作者
     * operator
     */
    @Column
    @ApiModelProperty(name = "operator", value = "操作管理员姓名",
            dataType = "String", required = true, example = "李四")
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getTasteType() {
        return tasteType;
    }

    public void setTasteType(Byte tasteType) {
        this.tasteType = tasteType;
    }

    public Byte getBasicFeatures() {
        return basicFeatures;
    }

    public void setBasicFeatures(Byte basicFeatures) {
        this.basicFeatures = basicFeatures;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

        FmsFoodInfo that = (FmsFoodInfo) o;

        if (!id.equals(that.id)) {
            return false;
        }
        if (!name.equals(that.name)) {
            return false;
        }
        if (!price.equals(that.price)) {
            return false;
        }
        if (!remark.equals(that.remark)) {
            return false;
        }
        if (!tasteType.equals(that.tasteType)) {
            return false;
        }
        if (!basicFeatures.equals(that.basicFeatures)) {
            return false;
        }
        if (!status.equals(that.status)) {
            return false;
        }
        if (!picUrl.equals(that.picUrl)) {
            return false;
        }
        if (!place.equals(that.place)) {
            return false;
        }
        if (!type.equals(that.type)) {
            return false;
        }
        if (!createTime.equals(that.createTime)) {
            return false;
        }
        if (!operateTime.equals(that.operateTime)) {
            return false;
        }
        if (!operateIp.equals(that.operateIp)) {
            return false;
        }
        return operator.equals(that.operator);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + remark.hashCode();
        result = 31 * result + tasteType.hashCode();
        result = 31 * result + basicFeatures.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + picUrl.hashCode();
        result = 31 * result + place.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + createTime.hashCode();
        result = 31 * result + operateTime.hashCode();
        result = 31 * result + operateIp.hashCode();
        result = 31 * result + operator.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FmsFoodInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                ", tasteType=" + tasteType +
                ", basicFeatures=" + basicFeatures +
                ", status=" + status +
                ", picUrl='" + picUrl + '\'' +
                ", place='" + place + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", operateTime=" + operateTime +
                ", operateIp='" + operateIp + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}