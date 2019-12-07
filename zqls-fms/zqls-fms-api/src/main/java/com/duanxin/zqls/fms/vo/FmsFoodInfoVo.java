package com.duanxin.zqls.fms.vo;

import com.duanxin.zqls.fms.model.FmsFoodInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * food info view object
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 10:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "食物信息展示实体类")
public class FmsFoodInfoVo implements Serializable {

    private static final long serialVersionUID = -5736695422026046402L;
    @ApiModelProperty(name = "fmsFoodInfos", value = "食物信息集合", dataType = "List<List<FmsFoodInfo>>")
    private List<List<FmsFoodInfo>> fmsFoodInfos;
}
