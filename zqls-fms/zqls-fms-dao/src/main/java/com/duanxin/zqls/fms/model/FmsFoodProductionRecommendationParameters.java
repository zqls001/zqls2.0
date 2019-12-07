package com.duanxin.zqls.fms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "食物生产量推荐参数实体类")
public class FmsFoodProductionRecommendationParameters implements Serializable {

    private static final long serialVersionUID = 2275227349701423051L;
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
}