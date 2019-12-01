package com.duanxin.excle.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 膳食推荐参数表（待定）
 * fms_meal_recommendation_parameters
 * @author duanxin
 * @date 2019-11-28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FmsMealRecommendationParameters implements Serializable {

    private static final long serialVersionUID = 6867362837015494529L;
    /**
     * 膳食推荐参数表id
     * id
     */
    private Integer id;

    /**
     * 用户id
     * uid
     */
    private Integer uid;

    /**
     * 身高，单位cm
     * height
     */
    @ExcelProperty(index = 3)
    private Integer height;

    /**
     * 体重，单位KG
     * weight
     */
    @ExcelProperty(index = 4)
    private Integer weight;

    /**
     * 创建时间
     * create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    private Date renewTime;
}