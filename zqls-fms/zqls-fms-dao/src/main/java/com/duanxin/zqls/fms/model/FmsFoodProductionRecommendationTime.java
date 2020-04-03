package com.duanxin.zqls.fms.model;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 食物生产量推荐时间表
 * fms_food_production_recommendation_time
 * @author duanxin
 * @date 2019-12-03
 */
public class FmsFoodProductionRecommendationTime implements Serializable {

    private static final long serialVersionUID = -5809007140372435683L;

    public FmsFoodProductionRecommendationTime() {
    }

    /**
     * Id表id
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 日期
     * date
     */
    @Column
    private Date date;

    /**
     * 星期：1周一。。0周日
     * week
     */
    @Column
    private Byte week;

    /**
     * 类型：0周末，1节假日
     * type
     */
    @Column
    private Byte type;

    /**
     * 描述
     * remark
     */
    @Column
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getWeek() {
        return week;
    }

    public void setWeek(Byte week) {
        this.week = week;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FmsFoodProductionRecommendationTime that = (FmsFoodProductionRecommendationTime) o;

        if (!id.equals(that.id)) {
            return false;
        }
        if (!date.equals(that.date)) {
            return false;
        }
        if (!week.equals(that.week)) {
            return false;
        }
        if (!type.equals(that.type)) {
            return false;
        }
        return remark.equals(that.remark);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + week.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + remark.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FmsFoodProductionRecommendationTime{" +
                "id=" + id +
                ", date=" + date +
                ", week=" + week +
                ", type=" + type +
                ", remark='" + remark + '\'' +
                '}';
    }
}