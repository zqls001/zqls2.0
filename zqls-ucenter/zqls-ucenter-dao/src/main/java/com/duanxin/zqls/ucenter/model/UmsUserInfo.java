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
 * 用户基本信息表
 * ums_user_info
 * @author duanxin
 * @date 2019-12-03
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户信息实体类")
public class UmsUserInfo implements Serializable {

    private static final long serialVersionUID = -1010671372296752624L;
    /**
     * 用户基本表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", value = "用户基本信息主键id",
            dataType = "int", required = true, example = "1")
    private Integer id;

    /**
     * 用户帐号
     * aid
     */
    @Column
    @ApiModelProperty(name = "aid", value = "用户账号",
            dataType = "int", required = true, example = "200000001")
    private Integer aid;

    /**
     * 用户工号
     * job_number
     */
    @Column
    @ApiModelProperty(name = "jobNumber", value = "用户学工号",
            dataType = "String", required = true, example = "10200001")
    private String jobNumber;

    /**
     * 用户名：姓名
     * user_name
     */
    @Column
    @ApiModelProperty(name = "userName", value = "用户姓名",
            dataType = "String", required = true, example = "张三")
    private String userName;

    /**
     * 用户密码
     * password
     */
    @Column
    @ApiModelProperty(name = "password", value = "用户密码",
            dataType = "String", required = true, example = "123456")
    private String password;

    /**
     * 性别：0男，1女
     * gender
     */
    @ApiModelProperty(name = "gender", value = "用户性别", notes = "性别：0男，1女",
            dataType = "String", required = true, example = "0")
    private String gender;

    /**
     * 用户头像
     * head_pic
     */
    @Column
    @ApiModelProperty(name = "headPic", value = "用户头像", notes = "用户头像在分布式存储系统中的地址",
            dataType = "String", example = "http://39.120.106.154/A/E/C/S/E/A/S/zhangsan.jpg")
    private String headPic;

    /**
     * 用户电话号码
     * phone
     */
    @Column
    @ApiModelProperty(name = "phone", value = "用户手机号", notes = "需要用户自己绑定",
            dataType = "String", example = "18820198888")
    private String phone;

    /**
     * 用户邮箱
     * email
     */
    @Column
    @ApiModelProperty(name = "email", value = "用户邮箱地址", notes = "需要用户自己进行绑定",
            dataType = "String", example = "18820198888@163.com")
    private String email;

    /**
     * 用户备注
     * remark
     */
    @Column
    @ApiModelProperty(name = "remark", value = "用户描述", notes = "需要用户自己进行填写",
            dataType = "String", example = "我叫张三，男，兴趣：。。。。")
    private String remark;

    /**
     * 状态：0正常，1异常
     * status
     */
    @Column
    @ApiModelProperty(name = "status", value = "用户状态", notes = "用户状态信息：0正常，1冻结；当冻结时用户将无法进行任何操作",
            dataType = "int", required = true, example = "0")
    private Byte status;

    /**
     * 类型：0学生，1职工
     * type
     */
    @Column
    @ApiModelProperty(name = "type", value = "用户类型", notes = "用户类型：0学生，1职工",
            dataType = "String", required = true, example = "0")
    private String type;

    /**
     * 创建时间
     * create_time
     */
    @Column
    @ApiModelProperty(name = "createTime", value = "用户创建时间",
            dataType = "Date", required = true, example = "2019-12-06 08：53：01")
    private Date createTime;

    /**
     * 最后一次操作时间
     * operate_time
     */
    @Column
    @ApiModelProperty(name = "operateTime", value = "用户信息更新时间", notes = "当用户信息更改之后，该属性就进行更新",
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