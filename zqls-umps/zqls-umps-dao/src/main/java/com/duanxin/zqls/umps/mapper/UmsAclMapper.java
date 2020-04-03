package com.duanxin.zqls.umps.mapper;

import com.duanxin.zqls.umps.model.UmsAcl;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UmsAclMapper extends Mapper<UmsAcl> {

    @Select({
            "<script>",
            "select `id`, `code`, `url`, `request_type`, `type`, `status`, `remark`, `operate_time`, `operate_ip`, `operator`",
            "from `ums_acl` " ,
            "where id in " ,
            "<foreach item = 'id' index = 'index' collection = 'aids' open = '(' separator = ',' close = ')'>" ,
            "#{id}" ,
            "</foreach>",
            "</script>"
    })
    @Results(id = "aclResultMap", value = {
            @Result(id = true, column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "request_type", property = "requestType", jdbcType = JdbcType.INTEGER),
            @Result(column = "type", property = "type", jdbcType = JdbcType.TINYINT),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "operate_time", property = "operateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "operate_ip", property = "operateIp", jdbcType = JdbcType.CHAR),
            @Result(column = "operator", property = "operator", jdbcType = JdbcType.VARCHAR),
    })
    List<UmsAcl> selectListByIds(@Param("aids") List<Integer> aids);
}