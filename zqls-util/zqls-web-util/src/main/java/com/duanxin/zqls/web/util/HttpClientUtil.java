package com.duanxin.zqls.web.util;

import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.web.base.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟http请求工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/12/13 10:20
 */
@Slf4j
public class HttpClientUtil {

    /**
     * get请求
     * @param url 请求地址
     * @date 2019/12/15 18:13
     * @return java.lang.String
     **/
    public static String doGet(String url) {
        try {
            log.info("get请求地址：{}", url);
            Content content = Request.Get(url).execute().returnContent();
            return content.asString();
        } catch (IOException e) {
            log.error("get请求出错", e);
        }
        return null;
    }

    /**
     * post请求
     * @param url 请求地址
     * @param map 参数
     * @date 2019/12/15 18:14
     * @return java.lang.String
     **/
    public static String doPost(String url, Map<String, Object> map) {

        Form form = Form.form();
        try {
            log.info("post请求地址：{}，请求参数：{}", url, map);
            map.forEach((key, value) -> form.add(key, value.toString()));
            Content content = Request.
                    Post(url).
                    bodyForm(form.build()).
                    execute().
                    returnContent();
            return content.asString();
        } catch (IOException e) {
            log.error("post请求出错", e);
        }
        return null;
    }

    /**
     * put请求
     * @param url 请求地址
     * @param map 参数
     * @date 2019/12/15 18:14
     * @return java.lang.String
     **/
    public static String doPut(String url, Map<String, Object> map) {
        Form form = Form.form();
        try {
            log.info("put请求地址：{}，请求参数：{}", url, map);
            map.forEach((key, value) -> form.add(key, value.toString()));
            Content content = Request.Put(url).
                    bodyForm(form.build()).
                    execute().
                    returnContent();
            return content.asString();
        } catch (IOException e) {
            log.error("put请求出错", e);
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("jobNumber", "10200001");
        map.put("password", "123456");
        // 进行登入请求
        String doPost = HttpClientUtil.doPost("http://localhost:8072/passport/login", map);
        BaseResult result2 = GsonUtil.jsonToBean(doPost, BaseResult.class);
        System.out.println(result2.getData());
    }
}
