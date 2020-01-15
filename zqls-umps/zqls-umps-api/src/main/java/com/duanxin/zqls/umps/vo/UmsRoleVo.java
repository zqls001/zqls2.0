package com.duanxin.zqls.umps.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * role view object
 * @author duanxin
 * @version 1.0
 * @date 2020/1/15 9:56
 */
@Getter
@Setter
@Builder
public class UmsRoleVo implements Serializable {
    private static final long serialVersionUID = -401602594464764121L;
    private String name;

    private Byte type;

    private Byte status;

    private String remark;
}
