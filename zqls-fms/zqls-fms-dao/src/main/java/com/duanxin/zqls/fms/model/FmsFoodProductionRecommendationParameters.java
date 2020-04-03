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
 * 食物生产量推荐参数表
 * fms_food_production_recommendation_parameters
 * @author duanxin
 * @date 2019-12-03
 */
@ApiModel(description = "食物生产量推荐参数实体类")
public class FmsFoodProductionRecommendationParameters implements Serializable {

    private static final long serialVersionUID = 2275227349701423051L;

    public FmsFoodProductionRecommendationParameters() {
    }

    /**
     * 食物生产量推荐参数表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "食物生产量推荐参数表主键id",
            dataType = "int", required = true, example = "1")
    private Integer id;

    /**
     * 食物消耗id
     * cid
     */
    @Column
    @ApiModelProperty(name = "cid", value = "食物消耗主键id",
            dataType = "int", required = true, example = "1")
    private Integer cid;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "食物生产量推荐参数创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    @ApiModelProperty(name = "renewTime", value = "食物生产量推荐参数更新时间", notes = "当该条记录更改后，该字段将自动更新",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date renewTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

        FmsFoodProductionRecommendationParameters that = (FmsFoodProductionRecommendationParameters) o;

        if (!id.equals(that.id)) {
            return false;
        }
        if (!cid.equals(that.cid)) {
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
        result = 31 * result + cid.hashCode();
        result = 31 * result + createTime.hashCode();
        result = 31 * result + renewTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FmsFoodProductionRecommendationParameters{" +
                "id=" + id +
                ", cid=" + cid +
                ", createTime=" + createTime +
                ", renewTime=" + renewTime +
                '}';
    }
}