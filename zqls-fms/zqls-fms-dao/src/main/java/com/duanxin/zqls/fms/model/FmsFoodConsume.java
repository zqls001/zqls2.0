package com.duanxin.zqls.fms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 食物消耗表
 * fms_food_consume
 * @author duanxin
 * @date 2019-09-17
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FmsFoodConsume implements Serializable {

    private static final long serialVersionUID = -7659617719505281824L;
    /**
     * 食物消耗表id
     * id
     */
    private Integer id;

    /**
     * 食物id
     * fid
     */
    private Integer fid;

    /**
     * 用户工号
     * uid
     */
    private String uid;

    /**
     * 食物质量
     * food_quality
     */
    private BigDecimal foodQuality;

    /**
     * 类型：0早，1中，2晚
     * type
     */
    private Byte type;

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