package top.hastur23.blogServer.service;

import org.springframework.stereotype.Service;
import top.hastur23.blogServer.mapper.BlogItemMapper;
import top.hastur23.blogServer.entity.BlogItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BlogItemService {
    @Autowired
    BlogItemMapper blogItemMapper;

    public List<BlogItem> getBlogItemByPage(int currentPage, int pageSize) {
        int offset = (currentPage - 1) * pageSize;
        return blogItemMapper.getBlogItemByPage(offset, pageSize);
    }

    public int getTotalCount() {
        return blogItemMapper.getTotalCount();
    }
}
