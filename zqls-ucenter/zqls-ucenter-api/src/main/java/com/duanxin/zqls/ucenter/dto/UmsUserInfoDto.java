package com.duanxin.zqls.ucenter.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用户信息
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:11
 */
public class UmsUserInfoDto implements Serializable {

    public UmsUserInfoDto() {
    }

    private static final long serialVersionUID = -1665437645075738445L;

    private Integer id;

    private Integer aid;

    private String jobNumber;

    private String userName;

    private String gender;

    private String headPic;

    private String phone;

    private String email;

    private String remark;

    private Byte status;

    private String type;

    private String userUniqueToken;

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

    public String getUserUniqueToken() {
        return userUniqueToken;
    }

    public void setUserUniqueToken(String userUniqueToken) {
        this.userUniqueToken = userUniqueToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsUserInfoDto that = (UmsUserInfoDto) o;

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
        return Objects.equals(userUniqueToken, that.userUniqueToken);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (aid != null ? aid.hashCode() : 0);
        result = 31 * result + (jobNumber != null ? jobNumber.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (headPic != null ? headPic.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (userUniqueToken != null ? userUniqueToken.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsUserInfoDto{" +
                "id=" + id +
                ", aid=" + aid +
                ", jobNumber='" + jobNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", headPic='" + headPic + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", userUniqueToken='" + userUniqueToken + '\'' +
                '}';
    }
}
