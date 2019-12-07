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
import java.math.BigDecimal;
import java.util.Date;

/**
 * 食物基本信息表
 * fms_food_info
 * @author duanxin
 * @date 2019-12-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "食物基本信息实体类")
public class FmsFoodInfo implements Serializable {

    private static final long serialVersionUID = 943459489691908864L;
    /**
     * 食物基本表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "食物基本信息主键id",
            dataType = "int", required = true, example = "1")
    private Integer id;

    /**
     * 食物名称
     * name
     */
    @Column
    @ApiModelProperty(name = "name", value = "食物名称",
            dataType = "String", required = true, example = "小鸡炖蘑菇")
    private String name;

    /**
     * 食物价格，单位（克/元）
     * price
     */
    @Column
    @ApiModelProperty(name = "price", value = "食物价格，单位（克/元）",
            dataType = "BigDecimal", required = true, example = "0.01")
    private BigDecimal price;

    /**
     * 食物备注
     * remark
     */
    @Column
    @ApiModelProperty(name = "remark", value = "食物描述",
            dataType = "String", example = "小鸡炖蘑菇：味道鲜美，营养丰富")
    private String remark;

    /**
     * 口味类型：0酸，1甜，2苦，3辣，4香，5咸
     * taste_type
     */
    @Column
    @ApiModelProperty(name = "tasteType", value = "食物口味：0酸，1甜，2苦，3辣，4香，5咸",
            dataType = "int", required = true, example = "5")
    private Byte tasteType;

    /**
     * 基本特征：0葱，1蒜，2姜，3香菜，4其他
     * basic_features
     */
    @Column
    @ApiModelProperty(name = "basicFeatures", value = "食物基本特征：0葱，1蒜，2姜，3香菜，4其他",
            dataType = "int", required = true, example = "4")
    private Byte basicFeatures;

    /**
     * 状态：0正常，1冻结
     * status
     */
    @Column
    @ApiModelProperty(name = "status", value = "食物状态：0正常，1冻结",
            dataType = "int", required = true, example = "0")
    private Byte status;

    /**
     * 图片地址
     * pic_url
     */
    @Column
    @ApiModelProperty(name = "picUrl", value = "食物图片地址",
            dataType = "String", example = "http://39.120.106.154/A/E/C/S/E/A/S/xiaojidunmogu.jpg")
    private String picUrl;

    /**
     * 所在地点
     * place
     */
    @Column
    @ApiModelProperty(name = "place", value = "食物所在地方",
            dataType = "String", required = true, example = "和畅")
    private String place;

    /**
     * 类型：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类
     * type
     */
    @Column
    @ApiModelProperty(name = "type", value = "食物类型：0谷物类，1蔬菜类，2水果类，3汤水类，4肉类，5豆类",
            dataType = "int", required = true, example = "0")
    private Byte type;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "食物创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 最后一次操作时间
     * operate_time
     */
    @Column
    @ApiModelProperty(name = "operateTime", value = "食物更新时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date operateTime;

    /**
     * 操作者ip
     * operate_ip
     */
    @Column
    @ApiModelProperty(name = "operateIp", value = "管理员操作ip地址",
            dataType = "String", required = true, example = "0.0.0.0")
    private String operateIp;

    /**
     * 操作者
     * operator
     */
    @Column
    @ApiModelProperty(name = "operator", value = "操作管理员姓名",
            dataType = "String", required = true, example = "李四")
    private String operator;
}