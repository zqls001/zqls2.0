package com.duanxin.zqls.common.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * 日期工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 11:07
 */
public class DateTimeUtil {

    public static final DateTimeFormatter TIME_FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter MONTH_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM");
    public static final DateTimeFormatter SHORT_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yy-MM-dd");
    public static final DateTimeFormatter SHORT_DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 返回当前的日期
     * @return LocalDate
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前时间
     * @return LocalTime
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    /**
     * 返回当前日期时间
     * @return LocalDateTime
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * yyyy-MM-dd
     *
     * @return String
     */
    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * yy-MM-dd
     *
     * @return String
     */
    public static String getCurrentShortDateStr() {
        return LocalDate.now().format(SHORT_DATE_FORMATTER);
    }

    /**
     * yyyy-MM
     * @date 2019/11/16 11:11
     * @return java.lang.String
     **/
    public static String getCurrentMonthStr() {
        return LocalDate.now().format(MONTH_FORMATTER);
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * @date 2019/11/16 11:12
     * @return java.lang.String
     **/
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * yy-MM-dd HH:mm:ss
     * @date 2019/11/16 11:13
     * @return java.lang.String
     **/
    public static String getCurrentShortDateTimeStr() {
        return LocalDateTime.now().format(SHORT_DATETIME_FORMATTER);
    }

    /**
     * hh:MM:ss
     * @date 2019/11/16 11:14
     * @return java.lang.String
     **/
    public static String getCurrentTimeStr() {
        return LocalTime.now().format(TIME_FORMATTER);
    }

    /**
     * 转化当前日期
     * @param pattern 日期格式
     * @date 2019/11/16 11:14
     * @return java.lang.String
     **/
    public static String getCurrentDateStr(String pattern) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转化当前日期时间
     * @param pattern 日期时间格式
     * @date 2019/11/16 11:14
     * @return java.lang.String
     **/
    public static String getCurrentDateTimeStr(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转化当前时间
     * @param pattern 时间格式
     * @date 2019/11/16 11:15
     * @return java.lang.String
     **/
    public static String getCurrentTimeStr(String pattern) {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转化日期
     * @param dateStr 日期
     * @param pattern 日期格式
     * @date 2019/11/16 11:15
     * @return java.time.LocalDate
     **/
    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转化日期时间
     * @param dateTimeStr 日期时间
     * @param pattern 日期时间格式
     * @date 2019/11/16 11:16
     * @return java.time.LocalDateTime
     **/
    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转化时间
     * @param timeStr 时间
     * @param pattern 时间格式
     * @date 2019/11/16 11:16
     * @return java.time.LocalTime
     **/
    public static LocalTime parseLocalTime(String timeStr, String pattern) {
        return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转化日期
     * @param date 日期
     * @param pattern 日期格式
     * @date 2019/11/16 11:16
     * @return java.lang.String
     **/
    public static String formatLocalDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转化日期时间
     * @param datetime 日期时间
     * @param pattern 日期时间格式
     * @date 2019/11/16 11:17
     * @return java.lang.String
     **/
    public static String formatLocalDateTime(LocalDateTime datetime, String pattern) {
        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转化时间
     * @param time 时间
     * @param pattern 时间格式
     * @date 2019/11/16 11:17
     * @return java.lang.String
     **/
    public static String formatLocalTime(LocalTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 转化日期为 yyyy-MM-dd
     * @param dateStr 日期
     * @date 2019/11/16 11:17
     * @return java.time.LocalDate
     **/
    public static LocalDate parseLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    /**
     * 转化日期时间为 yyyy-MM-dd HH:mm:ss
     * @param dateTimeStr 日期时间
     * @date 2019/11/16 11:18
     * @return java.time.LocalDateTime
     **/
    public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
    }

    /**
     * 转化时间为 HH:mm:ss
     * @param timeStr 时间
     * @date 2019/11/16 11:19
     * @return java.time.LocalTime
     **/
    public static LocalTime parseLocalTime(String timeStr) {
        return LocalTime.parse(timeStr, TIME_FORMATTER);
    }

    /**
     * 转化日期为 yyyy-MM-dd
     * @param date 日期
     * @date 2019/11/16 11:19
     * @return java.lang.String
     **/
    public static String formatLocalDate(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    /**
     * 转化日期时间为 yyyy-MM-dd HH:mm:ss
     * @param datetime 日期时间
     * @date 2019/11/16 11:20
     * @return java.lang.String
     **/
    public static String formatLocalDateTime(LocalDateTime datetime) {
        return datetime.format(DATETIME_FORMATTER);
    }

    /**
     * 转化时间为 HH:mm:ss
     * @param time 时间
     * @date 2019/11/16 11:20
     * @return java.lang.String
     **/
    public static String formatLocalTime(LocalTime time) {
        return time.format(TIME_FORMATTER);
    }

    /**
     * 日期相隔天数
     * @param startDateInclusive 开始时间
     * @param endDateExclusive 结束时间
     * @return int
     */
    public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }

    /**
     * 日期相隔小时
     * @param startInclusive 开始时间
     * @param endExclusive 结束时间
     * @return long
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     * @param startInclusive 开始时间
     * @param endExclusive 结束时间
     * @return long
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     * @param startInclusive 开始时间
     * @param endExclusive 结束时间
     * @return long
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 是否当天
     * @param date 日期
     * @return boolean
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    /**
     *
     * @param dateTime 日期时间
     * @date 2019/11/16 11:22
     * @return java.lang.Long
     **/
    public static Long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 某个时间的天数间隔
     * @param dateTime 时间日期
     * @param days 间隔天数，负为往前推，正为往后推
     * @date 2019/11/16 11:30
     * @return java.time.LocalDateTime
     **/
    public static LocalDateTime minusDays(LocalDateTime dateTime, long days) {
        return dateTime.minusDays(days);
    }
}
