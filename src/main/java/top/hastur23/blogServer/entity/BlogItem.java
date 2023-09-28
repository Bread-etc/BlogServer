package top.hastur23.blogServer.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class BlogItem {
    private int id;
    private String alias;
    private String title;
    private String content;
    private String image;
    private String category;
    private Date time;
}