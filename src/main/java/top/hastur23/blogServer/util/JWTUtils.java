package top.hastur23.blogServer.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    // 密钥
    private static final String SING = "Bread_etc";

    /*
     * 生成token
     * */
    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        // 默认 7天 过期
        instance.add(Calendar.DATE, 7);
        // 创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SING));
        return token;
    }

    /*
     * 验证 token 合法性
     * */
    public static DecodedJWT verify(String token) {
        // 返回验证结果 (结果是内置的)
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }
}