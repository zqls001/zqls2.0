package com.duanxin.excle.contains;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/12/1 10:46
 */
public class FavoriteDishesContain {

    private final static String FAVORITE_DISHES_1 = "谷物类";

    private final static String FAVORITE_DISHES_2 = "蔬菜类";

    private final static String FAVORITE_DISHES_3 = "水果类";

    private final static String FAVORITE_DISHES_4 = "汤水类";

    private final static String FAVORITE_DISHES_5 = "肉类";

    private final static String FAVORITE_DISHES_6 = "豆类";

    public static Byte getTypeId(String typeName) {
        switch (typeName) {
            case FAVORITE_DISHES_1 : return Byte.valueOf("0");
            case FAVORITE_DISHES_2 : return Byte.valueOf("1");
            case FAVORITE_DISHES_3 : return Byte.valueOf("2");
            case FAVORITE_DISHES_4 : return Byte.valueOf("3");
            case FAVORITE_DISHES_5 : return Byte.valueOf("4");
            case FAVORITE_DISHES_6 : return Byte.valueOf("5");
            default : return null;
        }
    }

}
