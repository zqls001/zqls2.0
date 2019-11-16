package com.duanxin.zqls.fms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 食物推荐表
 * fms_food_recommend
 * @author duanxin
 * @date 2019-09-17
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FmsFoodRecommend implements Serializable {

    private static final long serialVersionUID = 8209044638753870496L;
    /**
     * 食物推荐表id
     * id
     */
    private Integer id;

    /**
     * 用户id
     * uid
     */
    private Integer uid;

    /**
     * 食物id
     * fid
     */
    private Integer fid;

    /**
     * 类型：0喜好菜品推荐，1膳食推荐
     * type
     */
    private Byte type;

    /**
     * 创建时间
     * create_time
     */
    private Date createTime;

    /**
     * 更新时间
     * renew_time
     */
    private Date renewTime;

}