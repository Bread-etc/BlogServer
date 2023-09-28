package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.hastur23.blogServer.entity.BlogItem;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.service.BlogItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
    @Autowired
    private BlogItemService blogItemService;

    @PostMapping("/update/blogItem")
    public Response insertBlogItem(@RequestBody BlogItem blogItem) {
        try {
            int result = blogItemService.insertBlogItem(blogItem);
            return Response.success(result);
        } catch (Exception e) {
            return Response.failure(500, "服务器异常");
        }
    }

    @PostMapping("/info/blogItem")
    public Response getBlogItem(@RequestBody Map<String, Integer> params) {
        try {
            int currentPage = params.get("currentPage");
            int pageSize = 5;   // 返回pageSize为5
            List<BlogItem> blogItemList = blogItemService.getBlogItemByPage(currentPage, pageSize);
            int totalCount = blogItemService.getTotalCount();
            Map<String, Object> data = new HashMap<>();
            data.put("currentPage", currentPage);
            data.put("pageSize", pageSize);
            data.put("totalCount", totalCount);
            data.put("list", blogItemList);
            return Response.success(data);
        } catch (Exception e) {
            return Response.failure(500, "服务器异常");
        }
    }
}
