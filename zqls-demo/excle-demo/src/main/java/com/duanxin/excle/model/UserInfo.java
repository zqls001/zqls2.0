package com.duanxin.excle.model;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户属性
 * @author duanxin
 * @version 1.0
 * @date 2Data11/26 10:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {

    /**
     * 学工号
     * */
    @ExcelProperty(index = 0)
    private String jobNumber;

    /**
     * 姓名
     * */
    @ExcelProperty(index = 1)
    private String userName;

    /**
     * 性别
     * */
    @ExcelProperty(index = 2)
    private String gender;

    /**
     * 年龄
     * */
    @ExcelProperty(index = 3)
    private Integer age;

    /**
     * 身高
     * */
    @ExcelProperty(index = 4)
    private Integer height;

    /**
     * 体重
     * */
    @ExcelProperty(index = 5)
    private Integer weight;

    /**
     * 籍贯
     * */
    @ExcelProperty(index = 6)
    private String birthplace;

    /**
     * 口味1
     * */
    @ExcelProperty(index = 7)
    private String taste1;

    /**
     * 口味2
     * */
    @ExcelProperty(index = 8)
    private String taste2;

    /**
     * 忌口
     * */
    @ExcelProperty(index = 9)
    private String diet;

    /**
     * 喜好食物1
     * */
    @ExcelProperty(index = 10)
    private String favoriteFood1;

    /**
     * 喜好食物2
     * */
    @ExcelProperty(index = 11)
    private String favoriteFood2;

    /**
     * 电话号码
     * */
    @ExcelProperty(index = 12)
    private String phone;

    /**
     * 邮箱
     * */
    @ExcelProperty(index = 13)
    private String mail;
}
