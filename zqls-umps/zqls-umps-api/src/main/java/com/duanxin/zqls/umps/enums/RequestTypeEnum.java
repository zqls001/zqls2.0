package com.duanxin.zqls.umps.enums;

/**
 * 请求类型的枚举
 * @author duanxin
 * @date 2020/3/6 16:25
 **/
public enum RequestTypeEnum {

    /**
     * GET请求
     */
    get(0, "GET"),
    /**
     * POST请求
     */
    post(1, "POST"),
    /**
     * DELETE请求
     */
    delete(2, "DELETE"),
    /**
     * PUT请求
     */
    put(3, "PUT");

    public final Integer type;
    public final String value;

    RequestTypeEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public static String getValueByType(Integer type) {
        switch (type) {
            case 0:
                return get.value;
            case 1:
                return post.value;
            case 2:
                return delete.value;
            case 3:
                return put.value;
            default:
                return null;
        }
    }
}
