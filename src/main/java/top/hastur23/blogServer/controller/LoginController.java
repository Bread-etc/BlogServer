package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.service.LoginService;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Response login(@RequestParam String username, @RequestParam String encryptedPassword) {
        try {
            // 调用 LoginService 进行登录验证
            boolean loginResult = loginService.login(username, encryptedPassword);

            if (loginResult) {
                return Response.success("Login successfully");
            } else {
                return Response.failure(401, "invalid Password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure(500, "Login failed");
        }
    }
}
