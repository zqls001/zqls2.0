package com.duanxin.zqls.umps.mapper;

import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.model.UmsAclRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
            @Result(column = "operate_ip" , property = "operateIp", jdbcType = JdbcType.VARCHAR),
            @Result(column = "operator" , property = "operator", jdbcType = JdbcType.VARCHAR),
    })
    List<UmsAcl> selectAclInfosByRid(@Param("rid") Integer rid);
}