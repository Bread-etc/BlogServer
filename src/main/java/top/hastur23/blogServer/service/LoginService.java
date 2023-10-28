package top.hastur23.blogServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.hastur23.blogServer.util.rsaUtils;

import java.util.Objects;

public interface LoginService {
    String login(String encryptedPassword);
}

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String login(String encrypedPassword) {
        try {
            // 从 Redis 中获取私钥
            String privateKey = redisTemplate.opsForValue().get("privateKey");
            if (Objects.isNull(privateKey)) {
                return "Private key not found in Redis";
            }

            // 解密
            String decryptedPassword = rsaUtils.decrypt(encrypedPassword, privateKey);

            // 返回 token 实例
            return "Token1234324";
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occured during login!";
        }
    }
}
