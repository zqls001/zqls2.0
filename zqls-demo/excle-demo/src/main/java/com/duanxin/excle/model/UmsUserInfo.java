package com.duanxin.excle.model;

import com.alibaba.excel.annotation.ExcelProperty;
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
 * @date 2019-11-28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsUserInfo implements Serializable {

    private static final long serialVersionUID = 1017018200885841552L;
    /**
     * 用户基本表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty(index = 16)
    private Integer id;

    /**
     * 用户帐号
     * aid
     */
    @ExcelProperty(index = 15)
    @Column
    private Integer aid;

    /**
     * 用户工号
     * job_number
     */
    @ExcelProperty(index = 1)
    @Column
    private String jobNumber;

    /**
     * 用户名：姓名
     * user_name
     */
    @ExcelProperty(index = 2)
    @Column
    private String userName;

    /**
     * 用户密码
     * password
     */
    @Column
    private String password;

    /**
     * 性别：0男，1女
     * gender
     */
    @ExcelProperty(index = 3)
    @Column
    private String gender;

    /**
     * 用户头像
     * head_pic
     */
    @Column
    private String headPic;

    /**
     * 用户电话号码
     * phone
     */
    @ExcelProperty(index = 13)
    @Column
    private String phone;

    /**
     * 用户邮箱
     * email
     */
    @ExcelProperty(index = 14)
    @Column
    private String email;

    /**
     * 用户备注
     * remark
     */
    @Column
    private String remark;

    /**
     * 状态：0正常，1异常
     * status
     */
    @Column
    private Byte status;

    /**
     * 类型：0学生，1职工
     * type
     */
    @Column
    private String type;

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