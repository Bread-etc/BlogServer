package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.hastur23.blogServer.entity.BlogItem;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.service.BlogItemService;

@RestController
public class BlogController {
    @Autowired
    private BlogItemService blogItemService;

    @PostMapping("/blog/insert")
    public Response insertBlogItem(@RequestBody BlogItem blogItem) {
        try {
            int result = blogItemService.insertBlogItem(blogItem);
            return Response.success(result);
        } catch (Exception e) {
            return Response.failure(500, "服务器异常");
        }
    }

    @PostMapping("/blog/read")
    public Response getBlogItem(@RequestBody BlogItem blogItem) {
        try {
            BlogItem result = blogItemService.getBlogItem(blogItem);
            return Response.success(result);
        } catch (Exception e) {
            return Response.failure(500, "服务器异常");
        }
    }
}
