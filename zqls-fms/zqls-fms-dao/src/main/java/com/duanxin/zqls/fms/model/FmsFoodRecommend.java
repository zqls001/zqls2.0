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
 * 食物推荐表
 * fms_food_recommend
 * @author duanxin
 * @date 2019-12-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "食物推荐实体类")
public class FmsFoodRecommend implements Serializable {

    private static final long serialVersionUID = -1468433155597044696L;
    /**
     * 食物推荐表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "食物推荐表主键id",
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
     * 食物id
     * fid
     */
    @Column
    @ApiModelProperty(name = "fid", value = "食物主键id",
            dataType = "int", required = true, example = "1")
    private Integer fid;

    /**
     * 类型：0喜好菜品推荐，1膳食推荐
     * type
     */
    @Column
    @ApiModelProperty(name = "id", value = "食物推荐类型：0喜好菜品推荐，1膳食推荐",
            dataType = "int", required = true, example = "1")
    private Byte type;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "食物推荐创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    @ApiModelProperty(name = "renewTime", value = "食物推荐更新时间", notes = "当该条记录更改后，该字段将自动更新",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date renewTime;
}