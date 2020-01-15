package com.duanxin.zqls.umps.constants;

/**
 * 角色常量类
 * @author duanxin
 * @version 1.0
 * @date 2020/1/15 8:20
 */
public class RoleConstant {

    /**
     * 状态正常：0
     * */
    public final static String NORMAL_STATUS = "0";
    /**
     * 状态异常：1
     * */
    public final static String ABNORMAL_STATUS = "1";

    /**
     * 装换状态类型
     * @param status 状态字符串
     * @date 2020/1/15 8:26
     * @return java.lang.Byte
     **/
    public static Byte change(String status) {
        switch(status) {
            case "0": return Byte.parseByte("0");
            case "1": return Byte.parseByte("1");
            default : return null;
        }
    }
}
