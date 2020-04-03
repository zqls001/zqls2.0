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
 * 食物生产量推荐表
 * fms_food_production_recommendation
 * @author duanxin
 * @date 2019-12-03
 */
@ApiModel(description = "食物生产量推荐实体类")
public class FmsFoodProductionRecommendation implements Serializable {

    private static final long serialVersionUID = 3830008723759811248L;

    public FmsFoodProductionRecommendation() {
    }

    /**
     * 食物生产量推荐表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "食物生产量推荐主键id",
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
     * 生产量
     * production
     */
    @Column
    @ApiModelProperty(name = "production", value = "食物推荐生产量，单位（千克）",
            dataType = "BigDecimal", required = true, example = "20.220")
    private BigDecimal production;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "食物生产量推荐创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    @ApiModelProperty(name = "renewTime", value = "食物生产量推荐更新时间", notes = "当该记录更新后，该字段将自动更新",
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

    public BigDecimal getProduction() {
        return production;
    }

    public void setProduction(BigDecimal production) {
        this.production = production;
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

        FmsFoodProductionRecommendation that = (FmsFoodProductionRecommendation) o;

        if (!Objects.equals(id, that.id)) {
            return false;
        }
        if (!Objects.equals(fid, that.fid)) {
            return false;
        }
        if (!Objects.equals(production, that.production)) {
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
        result = 31 * result + (production != null ? production.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (renewTime != null ? renewTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FmsFoodProductionRecommendation{" +
                "id=" + id +
                ", fid=" + fid +
                ", production=" + production +
                ", createTime=" + createTime +
                ", renewTime=" + renewTime +
                '}';
    }
}