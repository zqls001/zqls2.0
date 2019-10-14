package com.duanxin.zqls.ucenter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户基本信息表
 * ums_user_info
 * @author duanxin
 * @date 2019-09-21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UmsUserInfo implements Serializable {

    private static final long serialVersionUID = -2896211115435321439L;
    /**
     * 用户基本表id
     * id
     */
    private Integer id;

    /**
     * 用户帐号
     * aid
     */
    private String aid;

    /**
     * 用户工号
     * job_number
     */
    private String jobNumber;

    /**
     * 用户名：姓名
     * user_name
     */
    private String userName;

    /**
     * 用户密码
     * password
     */
    private String password;

    /**
     * 性别：0男，1女
     * gender
     */
    private String gender;

    /**
     * 用户头像
     * head_pic
     */
    private String headPic;

    /**
     * 用户电话号码
     * phone
     */
    private String phone;

    /**
     * 用户邮箱
     * email
     */
    private String email;

    /**
     * 用户备注
     * remark
     */
    private String remark;

    /**
     * 状态：0正常，1异常
     * status
     */
    private Byte status;

    /**
     * 类型：0学生，1职工
     * type
     */
    private String type;

    /**
     * 创建时间
     * create_time
     */
    private Date createTime;

    /**
     * 最后一次操作时间
     * operate_time
     */
    private Date operateTime;

    /**
     * 操作者ip
     * operate_ip
     */
    private String operateIp;

    /**
     * 操作者
     * operator
     */
    private String operator;

    /**
     * 用户账户
     * */
    private List<UmsUserAccountInfo> umsUserAccountInfoList;

}