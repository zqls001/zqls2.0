package com.duanxin.zqls.ucenter.mapper;

import com.duanxin.zqls.ucenter.model.UmsUserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户信息dao层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/10/14 15:39
 */
public interface UmsUserInfoMapper extends Mapper<UmsUserInfo> {
    @Select({
            "<script>",
            "select `id`,`aid`,`job_number`,`user_name`,`password`,`gender`,`head_pic`,`phone`,`email`,`remark`,`status`,`type`,`create_time`,`operate_time`,`operate_ip`,`operator`",
            "from `ums_user_info`",
            "where `id` in ",
            "<foreach item = 'id' collection = 'uids' index = 'index' open = '(' separator = ',' close = ')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    @Results(id = "userResultMap", value = {
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
    List<UmsUserInfo> selectListByIds(@Param("uids") List<Integer> uids);
}
