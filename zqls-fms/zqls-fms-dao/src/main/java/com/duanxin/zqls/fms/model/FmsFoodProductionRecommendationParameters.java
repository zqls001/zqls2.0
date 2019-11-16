package com.duanxin.zqls.fms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 食物生产量推荐参数表
 * fms_food_production_recommendation_parameters
 * @author duanxin
 * @date 2019-09-17
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FmsFoodProductionRecommendationParameters implements Serializable {

    private static final long serialVersionUID = -33836113825642903L;
    /**
     * 食物生产量推荐参数表id
     * id
     */
    private Integer id;

    /**
     * 食物消耗id
     * cid
     */
    private Integer cid;

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