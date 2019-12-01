package com.duanxin.excle.model;

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
 * 用户喜好表
 * fms_user_like
 * @author duanxin
 * @date 2019-11-28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FmsUserLike implements Serializable {

    private static final long serialVersionUID = -9177604128897246109L;
    /**
     * 用户喜好表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     * uid
     */
    @Column
    private Integer uid;

    /**
     * 民族：0汉族，1其他
     * nation
     */
    @Column
    private Byte nation;

    /**
     * 地区：待定
     * area
     */
    @Column
    private String area;

    /**
     * 口味：0酸，1甜，2苦，3辣，4香，5咸
     * taste_type1
     */
    @Column
    private Byte tasteType1;

    /**
     * 口味：0酸，1甜，2苦，3辣，4香，5咸
     * taste_type2
     */
    @Column
    private Byte tasteType2;

    /**
     * 喜好菜类：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类
     * favorite_dishes1
     */
    @Column
    private Byte favoriteDishes1;

    /**
     * 喜好菜类：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类
     * favorite_dishes2
     */
    @Column
    private Byte favoriteDishes2;

    /**
     * 忌口：0葱，1蒜，2姜，3香菜，4无
     * diet
     */
    @Column
    private Byte diet;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    private Date renewTime;

    /**
     * 创建时间
     * create_time
     */
    @Column
    private Date createTime;
}