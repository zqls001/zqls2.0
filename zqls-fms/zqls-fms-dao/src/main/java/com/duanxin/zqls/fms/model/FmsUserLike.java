package com.duanxin.zqls.fms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
 * @date 2019-12-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "用户喜好实体类")
public class FmsUserLike implements Serializable {

    private static final long serialVersionUID = -1716589456107620175L;
    /**
     * 用户喜好表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "用户喜好主键id",
            dataType = "int", required = true, example = "1")
    private Integer id;

    /**
     * 用户id
     * uid
     */
    @Column
    @ApiModelProperty(name = "uid", value = "用户主键id",
            dataType = "int", required = true, example = "1")
    private Integer uid;

    /**
     * 民族：0汉族，1其他
     * nation
     */
    @Column
    @ApiModelProperty(name = "nation", value = "用户民族：0汉族，1其他",
            dataType = "int", required = true, example = "0")
    private Byte nation;

    /**
     * 地区：用户籍贯所在地
     * area
     */
    @Column
    @ApiModelProperty(name = "area", value = "用户所在籍贯",
            dataType = "String", required = true, example = "天津市")
    private String area;

    /**
     * 口味：0酸，1甜，2苦，3辣，4香，5咸
     * taste_type1
     */
    @Column
    @ApiModelProperty(name = "tasteType1", value = "用户口味1：0酸，1甜，2苦，3辣，4香，5咸",
            dataType = "int", required = true, example = "1")
    private Byte tasteType1;

    /**
     * 口味：0酸，1甜，2苦，3辣，4香，5咸
     * taste_type2
     */
    @Column
    @ApiModelProperty(name = "tasteType2", value = "用户口味2：0酸，1甜，2苦，3辣，4香，5咸",
            dataType = "int", required = true, example = "0")
    private Byte tasteType2;

    /**
     * 喜好菜类：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类
     * favorite_dishes1
     */
    @Column
    @ApiModelProperty(name = "favoriteDishes1", value = "用户喜好菜类1：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类",
            dataType = "int", required = true, example = "1")
    private Byte favoriteDishes1;

    /**
     * 喜好菜类：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类
     * favorite_dishes2
     */
    @Column
    @ApiModelProperty(name = "favoriteDishes2", value = "用户喜好菜类2：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类",
            dataType = "int", required = true, example = "4")
    private Byte favoriteDishes2;

    /**
     * 忌口：0葱，1蒜，2姜，3香菜，4无
     * diet
     */
    @Column
    @ApiModelProperty(name = "diet", value = "用户忌口：0葱，1蒜，2姜，3香菜，4无",
            dataType = "int", required = true, example = "4")
    private Byte diet;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "用户喜好创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date renewTime;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "renewTime", value = "用户喜好更新时间", notes = "当该条记录更改后，该字段将自动更新",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;
}