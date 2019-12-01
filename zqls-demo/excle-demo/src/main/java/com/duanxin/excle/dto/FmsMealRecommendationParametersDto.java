package com.duanxin.excle.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class FmsMealRecommendationParametersDto implements Serializable {

    private static final long serialVersionUID = 7882887087482012051L;
    /**
     * 用户id
     * uid
     */
    @ExcelProperty(index = 2)
    private Integer uid;

    /**
     * 身高，单位cm
     * height
     */
    @ExcelProperty(index = 0)
    private Integer height;

    /**
     * 体重，单位KG
     * weight
     */
    @ExcelProperty(index = 1)
    private Integer weight;


}