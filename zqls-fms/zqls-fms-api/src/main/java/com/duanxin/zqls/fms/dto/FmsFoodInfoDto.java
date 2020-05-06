package com.duanxin.zqls.fms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className FmsFoodInfoDto
 * @date 2020/04/30 14:28
 */
public class FmsFoodInfoDto implements Serializable {
    private static final long serialVersionUID = 4387594397597041812L;

    /**
     * 食物名称
     * name
     */
    private String name;

    /**
     * 食物价格，单位（克/元）
     * price
     */
    private BigDecimal price;

    /**
     * 食物备注
     * remark
     */
    private String remark;

    /**
     * 口味类型：0酸，1甜，2苦，3辣，4香，5咸
     * taste_type
     */
    private Byte tasteType;

    /**
     * 基本特征：0葱，1蒜，2姜，3香菜，4其他
     * basic_features
     */
    private Byte basicFeatures;

    /**
     * 状态：0正常，1冻结
     * status
     */
    private Byte status;

    /**
     * 图片地址
     * pic_url
     */
    private String picUrl;

    /**
     * 所在地点
     * place
     */
    private String place;

    /**
     * 类型：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类
     * type
     */
    private Byte type;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FmsFoodInfoDto that = (FmsFoodInfoDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(tasteType, that.tasteType) &&
                Objects.equals(basicFeatures, that.basicFeatures) &&
                Objects.equals(status, that.status) &&
                Objects.equals(picUrl, that.picUrl) &&
                Objects.equals(place, that.place) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, remark, tasteType, basicFeatures, status, picUrl, place, type);
    }

    @Override
    public String toString() {
        return "FmsFoodInfoDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                ", tasteType=" + tasteType +
                ", basicFeatures=" + basicFeatures +
                ", status=" + status +
                ", picUrl='" + picUrl + '\'' +
                ", place='" + place + '\'' +
                ", type=" + type +
                '}';
    }
}
