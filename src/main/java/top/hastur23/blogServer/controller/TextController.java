package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.hastur23.blogServer.entity.AliasInfo;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.service.TextService;

@RestController
public class TextController {
    @Autowired
    private TextService textService;

    @PostMapping("/info/text")
    public Response getBlogText(@RequestBody AliasInfo aliasInfo) {
        try {
            AliasInfo result = textService.getBlogText(aliasInfo);
            return Response.success(result);
        } catch (Exception e) {
            return Response.failure(500,"获取失败");
        }
    }

    @PostMapping("/update/text")
    public Response insertBlogText(@RequestBody AliasInfo aliasInfo) {
        try {
            int result = textService.insertBlogText(aliasInfo);
            return Response.success(result);
        } catch (Exception e) {
            return Response.failure(500, "更新文章失败");
        }
    }
}
