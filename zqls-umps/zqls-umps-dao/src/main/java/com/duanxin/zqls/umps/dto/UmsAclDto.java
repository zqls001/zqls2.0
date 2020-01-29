package com.duanxin.zqls.umps.dto;

import lombok.*;

import java.io.Serializable;

/**
 * 权限数据输出对象
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 9:19
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAclDto implements Serializable {
    private static final long serialVersionUID = 4211713956017479973L;

    private Integer id;

    private String code;

    private String name;

    private String url;

    private Byte type;

    private Byte status;

    private String remark;
}
