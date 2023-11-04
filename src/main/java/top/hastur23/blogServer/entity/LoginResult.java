package top.hastur23.blogServer.entity;

import lombok.Data;

@Data
public class LoginResult {
    private boolean success;
    private String token;

    public LoginResult(boolean success, String token) {
        this.success = success;
        this.token = token;
    }
}
