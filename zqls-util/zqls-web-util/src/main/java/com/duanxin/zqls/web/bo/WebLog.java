package com.duanxin.zqls.web.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Controller层日志封装类
 * @author duanxin
 * @version 1.0
 * @date 2019/12/24 11:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebLog {

    /**
     * 操作描述
     * */
    private String description;

    /**
     * 操作用户
     * */
    private String username;

    /**
     * 开始时间
     * */
    private Long startTime;

    /**
     * 消耗时间
     * */
    private Long spendTime;

    /**
     * 根路径
     * */
    private String basePath;

    /**
     * uri
     * */
    private String uri;

    /**
     * url
     * */
    private String url;

    /**
     * 请求类型
     * */
    private String method;

    /**
     * 请求ip地址
     * */
    private String ip;

    private Object parameter;

    private Object result;
}
