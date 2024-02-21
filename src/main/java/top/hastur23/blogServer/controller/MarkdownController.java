package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.hastur23.blogServer.entity.MarkdownFile;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.service.MarkdownService;

import java.util.Map;

@RestController
public class MarkdownController {

    @Autowired
    private MarkdownService markdownService;

    @PostMapping("/getMarkdown")
    public Response getMarkdownContent(@RequestBody Map<String, String> params) {
        MarkdownFile markdownFile = markdownService.getMarkdownContent(params.get("alias"));
        if (markdownFile != null) {
            return Response.success(markdownFile.getContent());
        } else {
            return Response.failure(404, "Markdown file not found:" + params.get("alias"));
        }
    }
}
