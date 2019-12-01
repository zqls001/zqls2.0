package com.duanxin.excle.contains;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/12/1 11:00
 */
public class DietContain {

    private final static String DIET_1 = "葱";
    private final static String DIET_2 = "蒜";
    private final static String DIET_3 = "姜";
    private final static String DIET_4 = "香菜";
    private final static String DIET_5 = "无";

    public static Byte getTypeId(String typeName) {
        switch (typeName) {
            case DIET_1 : return Byte.valueOf("0");
            case DIET_2 : return Byte.valueOf("1");
            case DIET_3 : return Byte.valueOf("2");
            case DIET_4 : return Byte.valueOf("3");
            case DIET_5 : return Byte.valueOf("4");
            default : return null;
        }
    }

}
