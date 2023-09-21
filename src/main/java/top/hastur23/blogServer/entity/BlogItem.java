package top.hastur23.blogServer.entity;

import lombok.Data;
@Data
public class BlogItem {
    private int id;
    private String content;
    private String title;
    private String image;
    private String category;
}
