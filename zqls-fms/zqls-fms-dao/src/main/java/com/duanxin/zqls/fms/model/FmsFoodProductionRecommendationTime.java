package com.duanxin.zqls.fms.model;
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
 * 食物生产量推荐时间表
 * fms_food_production_recommendation_time
 * @author duanxin
 * @date 2019-12-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FmsFoodProductionRecommendationTime implements Serializable {

    private static final long serialVersionUID = -5809007140372435683L;
    /**
     * Id表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 日期
     * date
     */
    @Column
    private Date date;

    /**
     * 星期：1周一。。0周日
     * week
     */
    @Column
    private Byte week;

    /**
     * 类型：0周末，1节假日
     * type
     */
    @Column
    private Byte type;

    /**
     * 描述
     * remark
     */
    @Column
    private String remark;
}