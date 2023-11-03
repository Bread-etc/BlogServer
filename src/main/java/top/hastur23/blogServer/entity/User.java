package top.hastur23.blogServer.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String password;
}
