package top.hastur23.blogServer.entity;

import lombok.Data;

@Data
public class BlogItem {
    private int id;
    private String title;
    private String content;
    private String image;
    private String category;
}