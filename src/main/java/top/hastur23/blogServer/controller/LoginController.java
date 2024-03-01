package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.hastur23.blogServer.entity.LoginResult;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.entity.User;
import top.hastur23.blogServer.service.LoginService;
import top.hastur23.blogServer.util.JWTUtils;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Response login(@RequestParam Map<String, String> request) {
        try {

            String username = request.get("username");
            String encryptedPassword = request.get("encryptedPassword");
            // 调用 LoginService 进行登录验证
            LoginResult loginResult = loginService.login(username, encryptedPassword);

            if (loginResult.isSuccess()) {
                // 生成 token 并且返回给客户端
                String token = JWTUtils.createToken(username);

                // 将 Token 保存到 User 实体类中
                User user = new User();
                user.setUsername(username);
                user.setToken(token);

                return Response.success(token);
            } else {
                return Response.failure(401, "invalid Password");
            }
        } catch (Exception e) {
            return Response.failure(500, "Login failed");
        }
    }
}
