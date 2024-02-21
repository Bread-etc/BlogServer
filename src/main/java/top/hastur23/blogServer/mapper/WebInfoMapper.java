package top.hastur23.blogServer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface WebInfoMapper {

    // 查询最后更新时间
    @Select("select time from blogItem order by id desc limit 1")
    Date getLastTime();
}
