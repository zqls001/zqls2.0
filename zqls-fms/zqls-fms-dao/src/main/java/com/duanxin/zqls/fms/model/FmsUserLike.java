package com.duanxin.zqls.fms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户喜好表
 * fms_user_like
 * @author duanxin
 * @date 2019-09-17
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FmsUserLike implements Serializable {

    private static final long serialVersionUID = -7321417156148357260L;
    /**
     * 用户喜好表id
     * id
     */
    private Integer id;

    /**
     * 用户id
     * uid
     */
    private Integer uid;

    /**
     * 民族：0汉族，1其他
     * nation
     */
    private Byte nation;

    /**
     * 地区：待定
     * area
     */
    private Byte area;

    /**
     * 口味：0酸，1甜，2苦，3辣
     * taste_type
     */
    private Byte tasteType;

    /**
     * 忌口：0葱，1蒜，2姜，3香菜
     * diet
     */
    private Byte diet;

    /**
     * 喜好菜类：0鲁菜，1川菜，2粤菜，3闽菜，4苏菜，5浙菜，6湘菜，7徽菜
     * favorite_dishes
     */
    private Byte favoriteDishes;

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