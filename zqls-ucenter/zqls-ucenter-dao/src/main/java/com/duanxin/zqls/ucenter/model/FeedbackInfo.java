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
import java.util.Date;

/**
 * 反馈基本表
 * feedback_info
 * @author duanxin
 * @date 2019-12-08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "用户反馈信息实体类")
public class FeedbackInfo implements Serializable {

    private static final long serialVersionUID = -6280699464210391587L;
    /**
     * 反馈表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "用户反馈信息主键id", dataType = "int", example = "1")
    private Integer id;

    /**
     * 用户id
     * uid
     */
    @Column
    @ApiModelProperty(name = "uid", value = "用户学工号",
            dataType = "String", example = "10200001")
    private String uid;

    /**
     * 反馈类型：0食物，1食堂环境，2系统改进，3其他
     * type
     */
    @Column
    @ApiModelProperty(name = "type", value = "用户反馈信息类型：0食物，1食堂环境，2系统改进，3其他",
            dataType = "int", example = "1")
    private Byte type;

    /**
     * 反馈描述
     * remark
     */
    @Column
    @ApiModelProperty(name = "remark", value = "用户反馈信息描述",
            dataType = "String", example = "描述：xxx食物中存在xxx问题")
    private String remark;

    /**
     * 状态：0未查看，1已查看，2已解决
     * status
     */
    @Column
    @ApiModelProperty(name = "status", value = "用户反馈信息所处的状态：0未查看，1已查看，2已解决",
            dataType = "int", example = "1")
    private Byte status;

    /**
     * 是否有图片：0无，1有
     * is_pic
     */
    @Column
    @ApiModelProperty(name = "isPic", value = "用户反馈信息是否有图片:0无，1有",
            dataType = "int", example = "1")
    private Byte isPic;

    /**
     * 图片url地址
     * pic_url
     */
    @Column
    @ApiModelProperty(name = "picUrl", value = "用户反馈信息相关图片地址", dataType = "String", example = "http://39.120.106.154/A/E/C/S/E/A/S/uuid.jpg")
    private String picUrl;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "用户反馈信息创建时间",
            dataType = "Date", example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    @Column
    @ApiModelProperty(name = "renewTime", value = "该记录只要更改，该字段就进行更新",
            dataType = "Date", example = "2019-12-06 08：53：01")
    private Date renewTime;
}