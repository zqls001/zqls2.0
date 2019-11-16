package com.duanxin.zqls.fms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 食物生产量推荐表
 * fms_food_production_recommendation
 * @author duanxin
 * @date 2019-09-17
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FmsFoodProductionRecommendation implements Serializable {

    private static final long serialVersionUID = -3465877016961476394L;
    /**
     * 食物生产量推荐表id
     * id
     */
    private Integer id;

    /**
     * 食物id
     * fid
     */
    private Integer fid;

    /**
     * 生产量
     * production
     */
    private BigDecimal production;

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