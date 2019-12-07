package com.duanxin.zqls.fms.constants;

import com.duanxin.zqls.common.util.DateTimeUtil;

import java.time.LocalTime;

/**
 * 时间常量类
 * @author duanxin
 * @version 1.0
 * @date 2019/12/5 9:01
 */
public class TimeConstant {

    /**
     * 早餐开始时间
     * */
    public final static LocalTime BREAKFAST_BEFOR_TIME =
            DateTimeUtil.parseLocalTime("06:30:00");
    /**
     * 早餐结束时间
     * */
    public final static LocalTime BREAKFAST_AFTER_TIME =
            DateTimeUtil.parseLocalTime("10:30:00");
    /**
     * 午餐开始时间
     * */
    public final static LocalTime LUNCH_BEFOR_TIME =
            DateTimeUtil.parseLocalTime("10:30:00");
    /**
     * 午餐结束时间
     * */
    public final static LocalTime LUNCH_AFTER_TIME =
            DateTimeUtil.parseLocalTime("15:30:00");
    /**
     * 晚餐开始时间
     * */
    public final static LocalTime DINNER_BEFOR_TIME =
            DateTimeUtil.parseLocalTime("15:30:00");
    /**
     * 晚餐结束时间
     * */
    public final static LocalTime DINNER_AFTER_TIME =
            DateTimeUtil.parseLocalTime("21:00:00");

    public static Byte getDateType(LocalTime time) {
        if (time.compareTo(BREAKFAST_BEFOR_TIME) > 0
                && time.compareTo(BREAKFAST_AFTER_TIME) <= 0) {
            return Byte.valueOf("0");
        }
        if (time.compareTo(LUNCH_BEFOR_TIME) > 0
                && time.compareTo(LUNCH_AFTER_TIME) <= 0) {
            return Byte.valueOf("1");
        }
        return Byte.valueOf("2");
    }
}
