package top.hastur23.blogServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.hastur23.blogServer.util.rsaUtils;

import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public boolean login(String username, String encryptedPassword) {
        try {
            // 从 Redis 中获取私钥
            String privateKey = redisTemplate.opsForValue().get("privateKey");
            if (Objects.isNull(privateKey)) {
                throw new RuntimeException("Private key not found in Redis");
            }

            // 解密
            String decryptedPassword = rsaUtils.decrypt(encryptedPassword, privateKey);

            if ("root".equals(username) && "GG166017".equals(decryptedPassword)) {
                // 如果用户名密码正确返回 true ,让用户进入/admin界面
                return true;
            } else {
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
