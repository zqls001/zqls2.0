package com.duanxin.zqls.web.bo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Controller层日志封装类
 * @author duanxin
 * @version 1.0
 * @date 2019/12/24 11:16
 */
public class WebLog implements Serializable {

    public WebLog() {
    }

    private static final long serialVersionUID = -2912121702265892609L;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Long spendTime) {
        this.spendTime = spendTime;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WebLog webLog = (WebLog) o;

        if (!Objects.equals(description, webLog.description)) {
            return false;
        }
        if (!Objects.equals(username, webLog.username)) {
            return false;
        }
        if (!Objects.equals(startTime, webLog.startTime)) {
            return false;
        }
        if (!Objects.equals(spendTime, webLog.spendTime)) {
            return false;
        }
        if (!Objects.equals(basePath, webLog.basePath)) {
            return false;
        }
        if (!Objects.equals(uri, webLog.uri)) {
            return false;
        }
        if (!Objects.equals(url, webLog.url)) {
            return false;
        }
        if (!Objects.equals(method, webLog.method)) {
            return false;
        }
        if (!Objects.equals(ip, webLog.ip)) {
            return false;
        }
        if (!Objects.equals(parameter, webLog.parameter)) {
            return false;
        }
        return Objects.equals(result, webLog.result);
    }

    @Override
    public int hashCode() {
        int result1 = description != null ? description.hashCode() : 0;
        result1 = 31 * result1 + (username != null ? username.hashCode() : 0);
        result1 = 31 * result1 + (startTime != null ? startTime.hashCode() : 0);
        result1 = 31 * result1 + (spendTime != null ? spendTime.hashCode() : 0);
        result1 = 31 * result1 + (basePath != null ? basePath.hashCode() : 0);
        result1 = 31 * result1 + (uri != null ? uri.hashCode() : 0);
        result1 = 31 * result1 + (url != null ? url.hashCode() : 0);
        result1 = 31 * result1 + (method != null ? method.hashCode() : 0);
        result1 = 31 * result1 + (ip != null ? ip.hashCode() : 0);
        result1 = 31 * result1 + (parameter != null ? parameter.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "WebLog{" +
                "description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", startTime=" + startTime +
                ", spendTime=" + spendTime +
                ", basePath='" + basePath + '\'' +
                ", uri='" + uri + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", ip='" + ip + '\'' +
                ", parameter=" + parameter +
                ", result=" + result +
                '}';
    }
}
