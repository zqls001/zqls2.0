package com.duanxin.zqls.ucenter.enums;

/**
 * 枚举：老师 学生
 * @author duanxin
 * @date 2020/3/6 16:57
 **/
public enum StudentOrTeacher {

    /**
     * 学生
     * */
    student(0, "student"),
    /**
     * 老师
     * */
    teacher(1, "teacher");

    public final Integer type;
    public final String value;

    StudentOrTeacher(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
