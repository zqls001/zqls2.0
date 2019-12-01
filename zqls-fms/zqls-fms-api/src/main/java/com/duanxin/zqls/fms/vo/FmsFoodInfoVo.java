package com.duanxin.zqls.fms.vo;

import com.duanxin.zqls.fms.model.FmsFoodInfo;
import lombok.AllArgsConstructor;
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
public class FmsFoodInfoVo implements Serializable {

    private static final long serialVersionUID = -5736695422026046402L;
    private List<FmsFoodInfo> fmsFoodInfos;
}
