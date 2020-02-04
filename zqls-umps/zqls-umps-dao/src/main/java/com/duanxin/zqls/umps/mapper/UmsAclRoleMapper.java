package com.duanxin.zqls.umps.mapper;

import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.model.UmsAclRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UmsAclRoleMapper extends Mapper<UmsAclRole> {

    @Select("select `id`, `code`, `name`, `url`, `type`, `status`, `remark`, `operate_time`, `operate_ip`, `operator`" +
            "from `ums_acl`" +
            "where `id` in (" +
            "select `aid` from `ums_acl_role` where `rid` = #{rid}" +
            ")")
    @Results(id = "aclResultMap", value = {
            @Result(id = true, column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name" , property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "url" , property = "url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "type" , property = "type", jdbcType = JdbcType.TINYINT),
            @Result(column = "status" , property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "remark" , property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "operate_time" , property = "operateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "operate_ip" , property = "operateIp", jdbcType = JdbcType.CHAR),
            @Result(column = "operator" , property = "operator", jdbcType = JdbcType.VARCHAR),
    })
    List<UmsAcl> selectAclInfosByRid(@Param("rid") Integer rid);

    @Select("select `aid` " +
            "from `ums_acl_role`" +
            "where rid = #{rid}")
    List<Integer> selectAidsByRid(@Param("rid") Integer rid);

    @Insert({
            "<script>",
            "insert into `ums_acl_role`(`aid`, `rid`, `operate_time`, `operate_ip`, `operator`) " ,
            "values" ,
            "<foreach item = 'u' collection = 'umsAclRoles' index = 'index' separator = ','>" ,
            "(#{u.aid}, #{u.rid}, #{u.operateTime}, #{u.operateIp}, #{u.operator})" ,
            "</foreach>",
            "</script>"
    })
    void insertBatch(@Param("umsAclRoles") List<UmsAclRole> umsAclRoles);
}