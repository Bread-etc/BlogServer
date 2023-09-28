package top.hastur23.blogServer.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.hastur23.blogServer.entity.BlogItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogItemMapper {
    int insertBlogItem(BlogItem blogItem);

    @Select("select * from blogitem LIMIT #{offset}, #{pageSize}")
    List<BlogItem> getBlogItemByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);

    @Select("select count(*) from blogitem")
    int getTotalCount();
}
