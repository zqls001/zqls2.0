package com.duanxin.demo.seata.module;

/**
 * 订单实体
 * @author duanxin
 * @version 1.0
 * @className OrderDO
 * @date 2020/05/06 11:45
 */
public class OrderDO {

    /** 订单编号 **/
    private Integer id;

    /** 用户编号 **/
    private Long userId;

    /** 产品编号 **/
    private Long productId;

    /** 支付金额 **/
    private Integer payAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }
}
