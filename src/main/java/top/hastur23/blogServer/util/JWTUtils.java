package top.hastur23.blogServer.util;

import cn.hutool.jwt.JWT;
import org.springframework.util.StringUtils;
import top.hastur23.blogServer.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// JWT 工具类
public class JWTUtils {

    // 密钥, 用于签名和验证
    private static final byte[] SECRET_KEY = "Bread_etc".getBytes();
    // 过期时间设置为 3天
    private static final long EXPIRE = 3 * 24 * 60 * 60;

    /**
    * 根据 username 生成 token
    *
    * @param userInfo 用户信息
    * @return token
    * */
    public static String generateTokenForUser(User userInfo) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", userInfo.getUsername());
        return generateToken(map);
    }

    /**
     * 根据 map 生成 token
     * 默认: HS265 (HmacSHA256)算法
     *
     * @param map
     * @return token
     * */
    public static String generateToken(Map<String, Object> map) {
        JWT jwt = JWT.create();
        // 设置携带参数
        map.forEach(jwt::setPayload);
        // 设置密钥
        jwt.setKey(SECRET_KEY);
        // 设置过期时间
        jwt.setExpiresAt(new Date(System.currentTimeMillis() + EXPIRE * 1000));
        return jwt.sign();
    }

    /**
     * token 校验
     *
     * @param token
     * @return 是否通过校验
     * */
    public static boolean verify (String token) {
        if (StringUtils.isBlank(token)) return false;
        return JWT.of(token).setKey(SECRET_KEY).verify();
    }

    /**
     * token 校验并且获取 userInfo
     *
     * @param token
     * @return userInfo
     * */
    public static User verifyAndGetUser(String token) {
        if (!verify(token)) return null;
        // 解析数据
        JWT jwt = JWT.of(token);
        String username = jwt.getPayload("username").toString();
        // 返回用户信息
        return new User(username);
    }

}
