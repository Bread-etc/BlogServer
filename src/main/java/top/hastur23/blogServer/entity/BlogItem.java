package top.hastur23.blogServer.entity;

import lombok.Data;
import java.sql.Date;

@Data
public class BlogItem {
    // id: No
    private int id;
    // alias: 文件名
    private String alias;
    // title: 文章标题
    private String title;
    // content: 文章简介
    private String content;
    // image: 文章首页图片
    private String image;
    // category: 标签 (tag)
    private String tag;
    // time: 发布时间
    private Date time;
}