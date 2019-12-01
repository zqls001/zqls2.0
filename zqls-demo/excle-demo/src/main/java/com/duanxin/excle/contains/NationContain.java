package com.duanxin.excle.contains;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/12/1 10:57
 */
public class NationContain {

    private final static String NATION_1 = "0";

    private final static String NATION_2 = "1";

    public static Byte getTypeId(String typeName) {
        switch (typeName) {
            case NATION_1 : return Byte.valueOf("0");
            case NATION_2 : return Byte.valueOf("1");
            default : return null;
        }
    }
}
