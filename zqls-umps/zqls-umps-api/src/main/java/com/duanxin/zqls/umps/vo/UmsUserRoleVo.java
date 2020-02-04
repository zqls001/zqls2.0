package com.duanxin.zqls.umps.vo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * ums user role view object
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:01
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UmsUserRoleVo implements Serializable {
    private static final long serialVersionUID = -6971574493953550448L;

    private Integer rid;

    private List<Integer> uids;
}
