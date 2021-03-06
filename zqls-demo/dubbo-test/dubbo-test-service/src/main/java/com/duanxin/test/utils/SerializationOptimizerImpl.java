package com.duanxin.test.utils;

import com.duanxin.test.model.UmsUserAccountInfo;
import com.duanxin.test.model.UmsUserInfo;
import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义序列化工具
 * @author duanxin
 * @version 1.0
 * @date 2019/10/19 8:52
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {

        List<Class> classList = new LinkedList<>();
        classList.add(UmsUserAccountInfo.class);
        classList.add(UmsUserInfo.class);
        return classList;
    }
}
