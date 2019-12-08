package com.duanxin.zqls.fms.ao;

import com.duanxin.zqls.fms.model.FmsUserLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户喜好应用对象
 * @author duanxin
 * @version 1.0
 * @date 2019/12/7 11:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FmsUserLikeAo implements Serializable {

    private static final long serialVersionUID = 5229669517263440774L;
    private Integer check;

    private FmsUserLike fmsUserLike;
}
