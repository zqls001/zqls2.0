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
 * 膳食推荐参数表
 * fms_meal_recommendation_parameters
 * @author duanxin
 * @date 2019-12-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "膳食推荐参数实体类")
public class FmsMealRecommendationParameters implements Serializable {

    private static final long serialVersionUID = 8728269161389460320L;
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
}