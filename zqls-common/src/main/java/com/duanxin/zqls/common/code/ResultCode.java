package com.duanxin.zqls.common.code;

import lombok.AllArgsConstructor;

/**
 * 结果状态码
 * @author duanxin
 * @version 1.0
 * @date 2019/9/15 14:34
 */
@AllArgsConstructor
public enum ResultCode implements IErrorCode {

    /** 操作成功状态码 */
    SUCCESS(200, "操作成功"),
    /** 操作失败状态码 */
    FAILED(500, "操作失败"),
    /** 参数校验失败状态码 */
    VALIDATE_FAILED(404, "参数检验失败"),
    /** 暂未登陆或token失效状态码 */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /** 无相关权限状态码 */
    FORBIDDEN(403, "没有相关权限");

    private int code;
    private String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }}
