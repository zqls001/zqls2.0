package com.duanxin.zqls.dubbo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/23 10:43
 */
public class StreamMain {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        System.out.println(list.stream().filter(s -> !s.equals("aaa")).collect(Collectors.toList()));
    }
}
