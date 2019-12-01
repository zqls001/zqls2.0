package com.duanxin.excle.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class UmsUserInfoDto implements Serializable {

    private static final long serialVersionUID = 5430617249286099989L;

    /**
     * 用户帐号
     * aid
     */
    @ExcelProperty(index = 14)
    private String aid;

    /**
     * 用户工号
     * job_number
     */
    @ExcelProperty(index = 0)
    private String jobNumber;

    /**
     * 用户名：姓名
     * user_name
     */
    @ExcelProperty(index = 1)
    private String userName;

    /**
     * 性别：0男，1女
     * gender
     */
    @ExcelProperty(index = 2)
    private String gender;

    /**
     * 用户电话号码
     * phone
     */
    @ExcelProperty(index = 12)
    private String phone;

    /**
     * 用户邮箱
     * email
     */
    @ExcelProperty(index = 13)
    private String email;
}