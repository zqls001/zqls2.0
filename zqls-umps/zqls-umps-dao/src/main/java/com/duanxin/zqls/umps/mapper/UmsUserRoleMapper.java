package com.duanxin.zqls.umps.mapper;

import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import com.duanxin.zqls.umps.model.UmsUserRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UmsUserRoleMapper extends Mapper<UmsUserRole> {

    @Select("select `id`, `aid`, `job_number`,`user_name`,`password`,`gender`,`head_pic`,`phone`,`email`,`remark`,`type`,`status`,`operate_ip`,`status`,`operator`,`operate_time`" +
            "from `ums_user_info`" +
            "where `id` in (" +
            "select `uid` from `ums_user_role` where `rid` = #{rid}" +
            ")")
    @Results(id = "userInfoResultMap", value = {
            @Result(id = true, column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "aid", property = "aid", jdbcType = JdbcType.INTEGER),
            @Result(column = "job_number", property = "jobNumber", jdbcType = JdbcType.CHAR),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.CHAR),
            @Result(column = "head_pic", property = "headPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.CHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "type", property = "type", jdbcType = JdbcType.CHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "operate_time", property = "operateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "operate_ip", property = "operateIp", jdbcType = JdbcType.VARCHAR),
            @Result(column = "operator", property = "operator", jdbcType = JdbcType.VARCHAR)
    })
    List<UmsUserInfo> selectUserListByRid(@Param("rid") Integer rid);

    @Select({
            "select `uid`",
            "from `ums_user_role`",
            "where rid = #{rid}"
    })
    List<Integer> selectUidsByRid(@Param("rid") Integer rid);

    @Insert({
            "<script>",
            "insert into `ums_user_role`(`rid`, `uid`, `operate_time`, `operate_ip`, `operator`) ",
            "values",
            "<foreach item = 'u' collection = 'umsUserRoles' index = 'index' separator = ','>",
            "(#{u.rid}, #{u.uid}, #{u.operateTime}, #{u.operateIp}, #{u.operator})",
            "</foreach>",
            "</script>"
    })
    void insertBatch(@Param("umsUserRoles") List<UmsUserRole> umsUserRoles);
}