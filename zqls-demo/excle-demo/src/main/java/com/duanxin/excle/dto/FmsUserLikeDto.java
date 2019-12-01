package com.duanxin.excle.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class FmsUserLikeDto implements Serializable {

    private static final long serialVersionUID = -6478616457241269649L;

    /**
     * 用户id
     * uid
     */
    @ExcelProperty(index = 16, value = "用户id")
    private Integer uid;

    /**
     * 民族：0汉族，1其他
     * nation
     */
    @ExcelProperty(index = 15, value = "民族")
    private String nation;

    /**
     * 地区：待定
     * area
     */
    @ExcelProperty(index = 6, value = "籍贯")
    private String area;

    /**
     * 口味：0酸，1甜，2苦，3辣，4香，5咸
     * taste_type1
     */
    @ExcelProperty(index =7, value = "口味1")
    private String tasteType1;

    /**
     * 口味：0酸，1甜，2苦，3辣，4香，5咸
     * taste_type2
     */
    @ExcelProperty(index = 8, value = "口味2")
    private String tasteType2;

    /**
     * 喜好菜类：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类
     * favorite_dishes1
     */
    @ExcelProperty(index = 10, value = "喜爱食物类型1")
    private String favoriteDishes1;

    /**
     * 喜好菜类：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类
     * favorite_dishes2
     */
    @ExcelProperty(index = 11, value = "喜爱食物类型2")
    private String favoriteDishes2;

    /**
     * 忌口：0葱，1蒜，2姜，3香菜，4无
     * diet
     */
    @ExcelProperty(index = 9, value = "忌口")
    private String diet;

}