package com.duanxin.demo.seata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.duanxin.demo.seata.mapper.ProductMapper;
import com.duanxin.demo.seata.service.ProductService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductServiceImpl
 * @date 2020/05/06 12:02
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private ProductMapper productMapper;

    @Override
    @DS(value = "storage-ds")
    @Transactional(propagation = Propagation.REQUIRES_NEW) // 开启新事物
    public void reduceStock(Long productId, Integer amount) throws Exception {
        LOGGER.info("#ProductServiceImpl.[reduceStock]# 当前 XID: {}", RootContext.getXID());

        // <3> 检查库存
        checkStock(productId, amount);

        LOGGER.info("#ProductServiceImpl.[reduceStock]# 开始扣减 {} 库存", productId);
        // <4> 扣减库存
        int updateCount = productMapper.reduceStock(productId, amount);
        // 扣除成功
        if (updateCount == 0) {
            LOGGER.warn("#ProductServiceImpl.[reduceStock]# 扣除 {} 库存失败", productId);
            throw new Exception("库存不足");
        }
        // 扣除失败
        LOGGER.info("#ProductServiceImpl.[reduceStock]# 扣除 {} 库存成功", productId);
    }

    private void checkStock(Long productId, Integer requiredAmount) throws Exception {
        LOGGER.info("#ProductServiceImpl.[checkStock]# 检查 {} 库存", productId);
        Integer stock = productMapper.getStock(productId);
        if (stock < requiredAmount) {
            LOGGER.warn("#ProductServiceImpl.[checkStock]# {} 库存不足，当前库存: {}", productId, stock);
            throw new Exception("库存不足");
        }
    }
}
