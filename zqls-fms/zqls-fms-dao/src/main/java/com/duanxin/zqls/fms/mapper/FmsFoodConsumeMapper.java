package com.duanxin.zqls.fms.mapper;

import com.duanxin.zqls.fms.model.FmsFoodConsume;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.time.LocalDateTime;
import java.util.List;

public interface FmsFoodConsumeMapper extends Mapper<FmsFoodConsume> {
    /**
     * select aPeriodOfTime data
     * @param now now datetime
     * @param lastThreeDays last datetime
     * @date 2019/11/16 11:47
     * @return java.util.List<com.duanxin.zqls.fms.model.FmsFoodConsume>
     **/
    @Select("select fid from fms_food_consume where create_time between #{last} and #{now} group by fid order by sum(food_quality) limit 10")
    List<FmsFoodConsume> getHotFmsFoodInfos(@Param("now") LocalDateTime now,
                                            @Param("last") LocalDateTime lastThreeDays);
}