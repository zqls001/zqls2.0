package com.duanxin.zqls.ucenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 用户基本信息表
 * ums_user_info
 * @author duanxin
 * @date 2019-12-03
 */
@ApiModel(description = "用户信息实体类")
public class UmsUserInfo implements Serializable {

    private static final long serialVersionUID = -1010671372296752624L;

    public UmsUserInfo() {
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsUserInfo that = (UmsUserInfo) o;

        if (!Objects.equals(id, that.id)) {
            return false;
        }
        if (!Objects.equals(aid, that.aid)) {
            return false;
        }
        if (!Objects.equals(jobNumber, that.jobNumber)) {
            return false;
        }
        if (!Objects.equals(userName, that.userName)) {
            return false;
        }
        if (!Objects.equals(password, that.password)) {
            return false;
        }
        if (!Objects.equals(gender, that.gender)) {
            return false;
        }
        if (!Objects.equals(headPic, that.headPic)) {
            return false;
        }
        if (!Objects.equals(phone, that.phone)) {
            return false;
        }
        if (!Objects.equals(email, that.email)) {
            return false;
        }
        if (!Objects.equals(remark, that.remark)) {
            return false;
        }
        if (!Objects.equals(status, that.status)) {
            return false;
        }
        if (!Objects.equals(type, that.type)) {
            return false;
        }
        if (!Objects.equals(createTime, that.createTime)) {
            return false;
        }
        if (!Objects.equals(operateTime, that.operateTime)) {
            return false;
        }
        if (!Objects.equals(operateIp, that.operateIp)) {
            return false;
        }
        return Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (aid != null ? aid.hashCode() : 0);
        result = 31 * result + (jobNumber != null ? jobNumber.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (headPic != null ? headPic.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (operateIp != null ? operateIp.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsUserInfo{" +
                "id=" + id +
                ", aid=" + aid +
                ", jobNumber='" + jobNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", headPic='" + headPic + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", createTime=" + createTime +
                ", operateTime=" + operateTime +
                ", operateIp='" + operateIp + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}