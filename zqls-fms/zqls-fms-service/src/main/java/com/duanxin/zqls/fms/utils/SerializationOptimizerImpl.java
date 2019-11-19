package com.duanxin.zqls.fms.utils;

import com.duanxin.zqls.fms.model.FmsFoodInfo;
import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * auto serialization optimizer
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 15:10
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {
    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new ArrayList<>();
        classes.add(FmsFoodInfo.class);
        return classes;
    }
}
