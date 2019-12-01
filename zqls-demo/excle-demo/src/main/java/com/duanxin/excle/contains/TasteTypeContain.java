package com.duanxin.excle.contains;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/12/1 10:41
 */
public class TasteTypeContain {

    private final static String TYPE_1 = "酸";

    private final static String TYPE_2 = "甜";

    private final static String TYPE_3 = "苦";

    private final static String TYPE_4 = "辣";

    private final static String TYPE_5 = "香";

    private final static String TYPE_6 = "咸";

    public static Byte getTypeId(String type) {
        switch (type) {
            case TYPE_1: return Byte.valueOf("0");
            case TYPE_2: return Byte.valueOf("1");
            case TYPE_3: return Byte.valueOf("2");
            case TYPE_5: return Byte.valueOf("4");
            case TYPE_4: return Byte.valueOf("3");
            case TYPE_6: return Byte.valueOf("5");
            default : return null;
        }
    }
}
