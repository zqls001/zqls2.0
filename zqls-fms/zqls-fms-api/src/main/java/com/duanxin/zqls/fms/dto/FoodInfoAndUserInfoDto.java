package com.duanxin.zqls.fms.dto;

import com.duanxin.zqls.fms.model.FmsFoodInfo;
import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 向硬件系统传递数据的封装对象
 * @author duanxin
 * @version 1.0
 * @date 2019/11/23 11:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodInfoAndUserInfoDto implements Serializable {

    private static final long serialVersionUID = -1389906432853819520L;
    /**
     * 食物信息
     * */
    private FmsFoodInfo fmsFoodInfo;

    /**
     * 用户个人账户信息
     * */
    private UmsUserAccountInfo umsUserAccountInfo;

    /**
     * 用户个人基本信息
     * */
    private UmsUserInfo umsUserInfo;
}
