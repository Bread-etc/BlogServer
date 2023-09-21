package top.hastur23.blogServer.service;

import org.springframework.stereotype.Service;
import top.hastur23.blogServer.mapper.BlogItemMapper;
import top.hastur23.blogServer.entity.BlogItem;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BlogItemService {
    @Autowired
    BlogItemMapper blogItemMapper;

    public int insertBlogItem(BlogItem blogItem) {
        return blogItemMapper.insertBlogItem(blogItem);
    }

    public BlogItem getBlogItem(BlogItem blogItem) {
        return blogItemMapper.getBlogItem(blogItem);
    }
}
