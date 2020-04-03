package com.duanxin.zqls.umps.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * ums user role view object
 * @author duanxin
 * @version 1.0
 * @date 2020/2/2 9:01
 */
public class UmsUserRoleVo implements Serializable {

    public UmsUserRoleVo() {
    }

    private static final long serialVersionUID = -6971574493953550448L;

    private Integer rid;

    private List<Integer> uids;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public List<Integer> getUids() {
        return uids;
    }

    public void setUids(List<Integer> uids) {
        this.uids = uids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UmsUserRoleVo that = (UmsUserRoleVo) o;

        if (!Objects.equals(rid, that.rid)) {
            return false;
        }
        return Objects.equals(uids, that.uids);
    }

    @Override
    public int hashCode() {
        int result = rid != null ? rid.hashCode() : 0;
        result = 31 * result + (uids != null ? uids.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UmsUserRoleVo{" +
                "rid=" + rid +
                ", uids=" + uids +
                '}';
    }
}
