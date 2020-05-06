package com.duanxin.demo.seata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductMapper
 * @date 2020/05/06 12:08
 */
@Mapper
@Repository
public interface ProductMapper {
    /**
     * 获取商品库存
     * @param productId 商品 ID
     * @date 2020/5/6 12:08
     * @return java.lang.Integer
     */
    @Select("SELECT stock FROM product WHERE id = #{productId}")
    Integer getStock(@Param("productId") Long productId);

    /**
     * 扣减库存
     * @param productId 商品 ID
     * @param amount 扣减数量
     * @date 2020/5/6 12:09
     * @return int
     */
    @Update("UPDATE product SET stock = stock - #{amount} WHERE id = #{productId} AND stock >= #{amount}")
    int reduceStock(@Param("productId") Long productId, @Param("amount") Integer amount);
}
