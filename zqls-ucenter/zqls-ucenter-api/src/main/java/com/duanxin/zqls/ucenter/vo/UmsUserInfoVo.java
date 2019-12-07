package com.duanxin.zqls.ucenter.vo;

import com.duanxin.zqls.ucenter.model.UmsUserAccountInfo;
import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息显示层对象
 * @author duanxin
 * @version 1.0
 * @date 2019/10/26 10:29
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户信息展示前端页面实体类")
public class UmsUserInfoVo implements Serializable {

    private static final long serialVersionUID = -2834690137786115839L;
    /**
     * 用户账户
     * */
    @ApiModelProperty(name = "umsUserAccountInfoList", value = "用户账户信息",
            dataType = "List<UmsUserAccountInfo>")
    private List<UmsUserAccountInfo> umsUserAccountInfoList;

    /**
     * 用户信息对象
     * */
    @ApiModelProperty(name = "umsUserInfo", value = "用户基本信息实体类",
            dataType = "UmsUserInfo", required = true)
    private UmsUserInfo umsUserInfo;
}
