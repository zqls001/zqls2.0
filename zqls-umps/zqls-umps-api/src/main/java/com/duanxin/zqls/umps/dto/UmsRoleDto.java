package com.duanxin.zqls.umps.dto;

import lombok.*;

import java.io.Serializable;

/**
 * 角色数据传输对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 8:42
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsRoleDto implements Serializable {
    private static final long serialVersionUID = 8421091907554693183L;
    private Integer id;

    private String name;

    private Byte type;

    private Byte status;

    private String remark;
}
