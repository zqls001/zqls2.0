package com.duanxin.zqls.umps.vo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * ums acl role view object
 * @author duanxin
 * @version 1.0
 * @date 2020/1/30 10:23
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAclRoleVo implements Serializable {
    private static final long serialVersionUID = -8355010797384222981L;

    private Integer rid;

    private List<Integer> aids;
}
