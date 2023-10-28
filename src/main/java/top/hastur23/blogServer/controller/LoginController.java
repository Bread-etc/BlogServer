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
    public Response login(@RequestParam String encryptedPassword) {
        String token = loginService.login(encryptedPassword);

        if (token != null) {
            return Response.success(token);
        } else {
            return Response.failure(500,"Login failed");
        }
    }
}
