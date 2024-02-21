package top.hastur23.blogServer.entity;

import lombok.Data;

@Data
public class WebInfo {
    private int articleNum;
    private String runTime;
    private int visitorsNum;
    private String lastUpdate;
}
