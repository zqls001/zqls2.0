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
 * 膳食推荐参数表
 * fms_meal_recommendation_parameters
 * @author duanxin
 * @date 2019-12-03
 */
@ApiModel(description = "膳食推荐参数实体类")
public class FmsMealRecommendationParameters implements Serializable {

    private static final long serialVersionUID = 8728269161389460320L;

    public FmsMealRecommendationParameters() {
    }

    /**
     * 膳食推荐Id表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "膳食推荐参数主键id",
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
     * 身高
     * height
     */
    @Column
    @ApiModelProperty(name = "height", value = "用户身高，单位（cm）",
            dataType = "int", required = true, example = "188")
    private Integer height;

    /**
     * 体重
     * weight
     */
    @Column
    @ApiModelProperty(name = "weight", value = "用户体重，单位（kg）",
            dataType = "int", required = true, example = "65")
    private Integer weight;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "膳食推荐创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    @ApiModelProperty(name = "renewTime", value = "膳食推荐更新时间", notes = "当该条记录更改后，该字段将自动更新",
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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

        FmsMealRecommendationParameters that = (FmsMealRecommendationParameters) o;

        if (!id.equals(that.id)) {
            return false;
        }
        if (!uid.equals(that.uid)) {
            return false;
        }
        if (!height.equals(that.height)) {
            return false;
        }
        if (!weight.equals(that.weight)) {
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
        result = 31 * result + height.hashCode();
        result = 31 * result + weight.hashCode();
        result = 31 * result + createTime.hashCode();
        result = 31 * result + renewTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FmsMealRecommendationParameters{" +
                "id=" + id +
                ", uid=" + uid +
                ", height=" + height +
                ", weight=" + weight +
                ", createTime=" + createTime +
                ", renewTime=" + renewTime +
                '}';
    }
}