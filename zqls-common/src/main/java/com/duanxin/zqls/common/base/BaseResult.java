package com.duanxin.zqls.common.base;
import com.duanxin.zqls.common.code.IErrorCode;
import com.duanxin.zqls.common.code.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


/**
 * 同意返回结果类
 * @author duanxin
 * @version 1.0
 * @date 2019/9/15 14:30
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult {

    /**
     * 状态码：1成功，其他失败
     * */
    private int code;

    /**
     * 提示信息：success成功，其他为失败原因
     * */
    private String message;

    /**
     * 数据结果集
     * */
    private Object data;

    /**
     * 操作成功返回结果
     * @param data 数据结果集
     * @date 2019/9/15 14:41
     * @return BaseResult
     **/
    public static BaseResult success(Object data) {
        return new BaseResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 操作成功返回结果
     * @param message 提示信息
     * @param data 数据结果集
     * @date 2019/9/15 14:42
     * @return BaseResult
     **/
    public static BaseResult success(String message, Object data) {
        return new BaseResult(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 操作失败返回结果
     * @param code 错误状态码
     * @date 2019/9/15 14:44
     * @return BaseResult
     **/
    private static BaseResult failed(IErrorCode code) {
        return new BaseResult(code.getCode(), code.getMessage(), null);
    }

    /**
     * 操作失败返回结果
     * @param message 提示信息
     * @date 2019/9/15 14:46
     * @return BaseResult
     **/
    public static BaseResult failed(String message) {
        return new BaseResult(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 操作失败返回结果
     * @date 2019/9/15 14:47
     * @return BaseResult
     **/
    public static BaseResult failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数校验失败返回结果
     * @param message 提示信息
     * @date 2019/9/15 14:48
     * @return BaseResult
     **/
    public static BaseResult validateFailed(String message) {
        return new BaseResult(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登入返回结果
     * @param data 数据结果集
     * @date 2019/9/15 14:50
     * @return BaseResult
     **/
    public static BaseResult unauthorized(Object data) {
        return new BaseResult(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     * @param data 数据结果集
     * @date 2019/9/15 14:52
     * @return BaseResult
     **/
    public static BaseResult forbidden(Object data) {
        return new BaseResult(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("code", code);
        map.put("message", message);
        map.put("data", data);

        return map;
    }
}
