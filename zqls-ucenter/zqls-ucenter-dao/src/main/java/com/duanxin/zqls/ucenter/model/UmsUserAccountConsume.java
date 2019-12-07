package com.duanxin.zqls.ucenter.model;

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
 * 用户消费表
 * ums_user_account_consume
 * @author duanxin
 * @date 2019-12-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "用户消费信息实体类")
public class UmsUserAccountConsume implements Serializable {

    private static final long serialVersionUID = 8638259735043904769L;
    /**
     * 用Id费id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "用户消费主键id",
            dataType = "int", required = true, example = "1")
    private Integer id;

    /**
     * 消费时间
     * time
     */
    @Column
    @ApiModelProperty(name = "time", value = "用户消费时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date time;

    /**
     * 消费地点
     * place
     */
    @Column
    @ApiModelProperty(name = "place", value = "用户消费地点",
            dataType = "String", required = true, example = "和畅")
    private String place;

    /**
     * 消费金额，单位（元）
     * price
     */
    @Column
    @ApiModelProperty(name = "price", value = "用户消费金额",
            dataType = "BigDecimal", required = true, example = "1.00")
    private BigDecimal price;
}