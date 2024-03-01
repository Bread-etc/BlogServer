package top.hastur23.blogServer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.hastur23.blogServer.entity.BlogItem;

import java.util.List;

@Mapper
public interface BlogItemMapper {

    // 查询所有的博客信息, 并进行分页
    @Select("select * from blogItem LIMIT #{offset}, #{pageSize}")
    List<BlogItem> getBlogItemByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);

    // 查询博客数量
    @Select("select count(alias) from blogItem")
    int getTotalCount();
}
