package com.duanxin.zqls.fms.model;

import com.duanxin.zqls.common.handler.MoneyTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.Money;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 食物基本信息表
 * fms_food_info
 * @author duanxin
 * @date 2019-09-17
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FmsFoodInfo implements Serializable {

    private static final long serialVersionUID = -418558797636040006L;
    /**
     * 食物基本表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 食物名称
     * name
     */
    @Column
    private String name;

    /**
     * 食物价格
     * price
     */
    @Column
    @ColumnType(jdbcType = JdbcType.BIGINT, typeHandler = MoneyTypeHandler.class)
    private Money price;

    /**
     * 食物备注
     * remark
     */
    @Column
    private String remark;

    /**
     * 口味类型：0酸，1甜，2苦，3辣
     * taste_type
     */
    @Column
    private Byte tasteType;

    /**
     * 基本特征：0葱，1蒜，2姜，3香菜
     * basic_features
     */
    @Column
    private Byte basicFeatures;

    /**
     * 状态：0正常，1冻结
     * status
     */
    @Column
    private Byte status;

    /**
     * 图片地址
     * pic_url
     */
    @Column
    private String picUrl;

    /**
     * 所在地点
     * place
     */
    @Column
    private String place;

    /**
     * 类型：0鲁菜，1川菜，2粤菜，3闽菜，4苏菜，5浙菜，6湘菜，7徽菜
     * type
     */
    @Column
    private Byte type;

    /**
     * 创建时间
     * create_time
     */
    @Column
    private Date createTime;

    /**
     * 最后一次操作时间
     * operate_time
     */
    @Column
    private Date operateTime;

    /**
     * 操作者ip
     * operate_ip
     */
    @Column
    private String operateIp;

    /**
     * 操作者
     * operator
     */
    @Column
    private String operator;

}