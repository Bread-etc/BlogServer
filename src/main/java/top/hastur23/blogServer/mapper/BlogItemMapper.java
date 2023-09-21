package top.hastur23.blogServer.mapper;

import top.hastur23.blogServer.entity.BlogItem;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogItemMapper {
    int insertBlogItem(BlogItem blogItem);

    BlogItem getBlogItem(BlogItem blogItem);
}
