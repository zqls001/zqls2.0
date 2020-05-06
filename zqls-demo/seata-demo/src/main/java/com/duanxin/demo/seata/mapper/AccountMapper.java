package com.duanxin.demo.seata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author duanxin
 * @version 1.0
 * @className AccountMapper
 * @date 2020/05/06 12:13
 */
@Mapper
@Repository
public interface AccountMapper {
    /**
     * 获取用户余额
     * @param userId 用户 ID
     * @date 2020/5/6 12:21
     * @return java.lang.Integer
     */
    @Select("SELECT balance FROM account WHERE id = #{userId}")
    Integer getBalance(Long userId);

    /**
     * 扣减用户余额
     * @param userId 用户 ID
     * @param price 扣减金额
     * @date 2020/5/6 12:22
     * @return int
     */
    @Update("UPDATE account SET balance = balance - #{price} WHERE id = 1 AND balance >= ${price}")
    int reduceBalance(Long userId, Integer price);
}
