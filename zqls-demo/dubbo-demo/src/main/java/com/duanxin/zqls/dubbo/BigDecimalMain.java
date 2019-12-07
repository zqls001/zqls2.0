package com.duanxin.zqls.dubbo;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/12/5 15:17
 */
public class BigDecimalMain {
    public static void main(String[] args) {
        BigDecimal m1 = new BigDecimal("1.21");
        BigDecimal m2 = new BigDecimal("1.2");
        System.out.println(m1.multiply(m2));
    }
}
