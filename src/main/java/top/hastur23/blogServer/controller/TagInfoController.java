package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.entity.Song;
import top.hastur23.blogServer.entity.TagInfo;
import top.hastur23.blogServer.service.TagInfoService;

import java.util.List;
import java.util.Map;

@RestController
public class TagInfoController {

    @Autowired
    private TagInfoService tagInfoService;

    @GetMapping("/analytic/getTag")
    public Response getTagInfo() {
        try {
            List<TagInfo> tagData = tagInfoService.getTagInfo();
            return Response.success(tagData);
        } catch (Exception e) {
            return Response.failure(500, "标签信息获取失败..");
        }
    }

    @GetMapping("/analytic/getArticle")
    public Response getArticle() {
        try {
            int articleResult = tagInfoService.getArticleNum();
            return Response.success(articleResult);
        } catch (Exception e) {
            return Response.failure(500, "文章数量信息获取失败..");
        }
    }

    @GetMapping("/analytic/getDays")
    public Response getDays() {
        try {
            long daysResult = tagInfoService.getDays();
            return Response.success(daysResult);
        } catch (Exception e) {
            return Response.failure(500, "运行天数获取失败..");
        }
    }

    @GetMapping("/getSong")
    public Response getSong() {
        try {
            String songResult = tagInfoService.getSong();
            return Response.success(songResult);
        } catch (Exception e) {
            return Response.failure(500, "歌曲链接获取失败..");
        }
    }

    @PostMapping("/reviseSong")
    public Response reviseSong(@RequestBody Song newLink) {
        try {
            boolean reviseResult = tagInfoService.reviseSong(newLink);
            return Response.success(reviseResult);
        } catch (Exception e) {
            return Response.failure(500, "修改歌曲链接失败..");
        }
    }

    @GetMapping("/getTagList")
    public Response getAllTagsWithAlias() {
        try {
            List<Map<String, Object>> tagListResult = tagInfoService.getTagAndAliases();
            return Response.success(tagListResult);
        } catch (Exception e) {
            return Response.failure(500, "获取标签列表和标题失败..");
        }
    }
}
