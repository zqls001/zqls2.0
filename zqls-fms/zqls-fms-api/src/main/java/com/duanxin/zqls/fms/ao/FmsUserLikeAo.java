package com.duanxin.zqls.fms.ao;

import com.duanxin.zqls.fms.model.FmsUserLike;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用户喜好应用对象
 * @author duanxin
 * @version 1.0
 * @date 2019/12/7 11:32
 */
public class FmsUserLikeAo implements Serializable {

    private static final long serialVersionUID = 5229669517263440774L;

    public FmsUserLikeAo() {
    }

    private Integer check;

    private FmsUserLike fmsUserLike;

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public FmsUserLike getFmsUserLike() {
        return fmsUserLike;
    }

    public void setFmsUserLike(FmsUserLike fmsUserLike) {
        this.fmsUserLike = fmsUserLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FmsUserLikeAo that = (FmsUserLikeAo) o;

        if (!Objects.equals(check, that.check)) {
            return false;
        }
        return Objects.equals(fmsUserLike, that.fmsUserLike);
    }

    @Override
    public int hashCode() {
        int result = check != null ? check.hashCode() : 0;
        result = 31 * result + (fmsUserLike != null ? fmsUserLike.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FmsUserLikeAo{" +
                "check=" + check +
                ", fmsUserLike=" + fmsUserLike +
                '}';
    }
}
