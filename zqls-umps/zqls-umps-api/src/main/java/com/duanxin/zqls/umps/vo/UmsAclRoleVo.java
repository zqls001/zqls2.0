package com.duanxin.zqls.umps.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * ums acl role view object
 * @author duanxin
 * @version 1.0
 * @date 2020/1/30 10:23
 */
public class UmsAclRoleVo implements Serializable {

    public UmsAclRoleVo() {
    }

    private static final long serialVersionUID = -8355010797384222981L;

    private Integer rid;

    private List<Integer> aids;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public List<Integer> getAids() {
        return aids;
    }

    public void setAids(List<Integer> aids) {
        this.aids = aids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsAclRoleVo that = (UmsAclRoleVo) o;

        if (!Objects.equals(rid, that.rid)) {
            return false;
        }
        return Objects.equals(aids, that.aids);
    }

    @Override
    public int hashCode() {
        int result = rid != null ? rid.hashCode() : 0;
        result = 31 * result + (aids != null ? aids.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsAclRoleVo{" +
                "rid=" + rid +
                ", aids=" + aids +
                '}';
    }
}
