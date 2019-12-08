package com.duanxin.zqls.fms.api;

import com.duanxin.zqls.fms.ao.FmsUserLikeAo;
import com.duanxin.zqls.fms.model.FmsUserLike;

/**
 * 用户喜好设置Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/12/7 11:19
 */
public interface FmsUserLikeService {
    /**
     * 设置用户喜好
     * @param fmsUserLike 用户喜好设置
     * @date 2019/12/7 11:25
     * @return int
     **/
    int saveUserLike(FmsUserLike fmsUserLike);

    /**
     * 根据用户主键id查询用户喜好信息
     * @param id 用户主键id
     * @date 2019/12/7 11:35
     * @return com.duanxin.zqls.fms.ao.FmsUserLikeAo
     **/
    FmsUserLikeAo getUserLikeByUid(Integer id);

    /**
     * 更新用户喜好
     * @param fmsUserLike 需更新用户喜好信息
     * @date 2019/12/8 9:58
     * @return com.duanxin.zqls.fms.ao.FmsUserLikeAo
     **/
    FmsUserLikeAo updateUserLike(FmsUserLike fmsUserLike);

    /**
     * 根据用户学工号删除或重置用户喜好设置
     * @param jobNumber 用户学工号
     * @date 2019/12/8 10:08
     * @return int
     **/
    int deleteByJobNumber(String jobNumber);
}
