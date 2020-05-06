package com.duanxin.demo.seata.mapper;

import com.duanxin.demo.seata.module.OrderDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderMapper
 * @date 2020/05/06 11:48
 */
@Mapper
@Repository
public interface OrderMapper {

    /**
     * 创建订单
     * @param order 订单实体
     * @date 2020/5/6 11:48
     * @return int
     */
    @Insert("INSERT INTO orders (user_id, product_id, pay_amount) VALUES (#{userId}, #{productId}, #{payAmount})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int saveOrder(OrderDO order);
}
