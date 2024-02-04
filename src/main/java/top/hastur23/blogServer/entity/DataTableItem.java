package top.hastur23.blogServer.entity;

import lombok.Data;

@Data
public class DataTableItem {
    // id: No
    private int id;
    // title: 标题
    private String title;
    // category: 标签 (tag)
    private String tag;
    // content: 文章简介
    private String content;
    // alias: 文件名
    private String alias;
    // img: 封面图片
    private String image;
}
