package com.duanxin.zqls.fms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 食物生产量推荐时间表
 * fms_food_production_recommendation_time
 * @author duanxin
 * @date 2019-09-17
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FmsFoodProductionRecommendationTime implements Serializable {

    private static final long serialVersionUID = 3941822955524756868L;
    /**
     * 时间表id
     * id
     */
    private Integer id;

    /**
     * 日期
     * date
     */
    private Date date;

    /**
     * 星期：1周一。。0周日
     * week
     */
    private Byte week;

    /**
     * 类型：0周末，1节假日
     * type
     */
    private Byte type;

    /**
     * 描述
     * remark
     */
    private String remark;

}