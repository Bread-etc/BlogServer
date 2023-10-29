package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.util.rsaUtils;

import java.time.Duration;
import java.util.Map;

@RestController
public class RSAController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/getPublicKey")
    public Response getPublicKey() {
        // 生成密钥对
        Map<String, String> keyPair = rsaUtils.generateKeyPair();
        String publicKey = keyPair.get("PUBLIC_KEY");
        String privateKey = keyPair.get("PRIVATE_KEY");

        // 将密钥存储在 Redis 中, 并设定过期时间
        redisTemplate.opsForValue().set("publicKey", publicKey, Duration.ofMinutes(3));
        redisTemplate.opsForValue().set("privateKey", privateKey, Duration.ofMinutes(3));

        return Response.success(publicKey);
    }
}
