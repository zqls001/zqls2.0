package com.duanxin.zqls.ucenter.dto;
import lombok.*;

import java.io.Serializable;

/**
 * 用户信息
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:11
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsUserInfoDto implements Serializable {
    private static final long serialVersionUID = -1665437645075738445L;

    private Integer id;

    private Integer aid;

    private String jobNumber;

    private String userName;

    private String gender;

    private String headPic;

    private String phone;

    private String email;

    private String remark;

    private Byte status;

    private String type;
}
