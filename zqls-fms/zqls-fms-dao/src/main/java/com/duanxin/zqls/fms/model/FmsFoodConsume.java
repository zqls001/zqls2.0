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
     * 食物Id表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 食物id
     * fid
     */
    @Column
    private Integer fid;

    /**
     * 用户工号
     * uid
     */
    @Column
    private String uid;

    /**
     * 食物质量
     * food_quality
     */
    @Column
    private BigDecimal foodQuality;

    /**
     * 类型：0早，1中，2晚
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
     * 更新时间
     * renew_time
     */
    @Column
    private Date renewTime;

}