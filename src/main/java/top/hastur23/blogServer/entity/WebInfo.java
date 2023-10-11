package top.hastur23.blogServer.entity;

import lombok.Data;

@Data
public class WebInfo {
    private int articleNum;
    private String uptime;
    private String totalWords;
    private int visitorsNum;
    private int totalPageViews;
    private String lastUpdate;
}
