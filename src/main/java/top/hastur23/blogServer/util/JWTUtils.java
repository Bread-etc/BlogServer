package top.hastur23.blogServer.util;

import top.hastur23.blogServer.entity.User;

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
        Map<String, String> map = new HashMap<>();
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
    public static String generateToken(Map<String, String> map) {

    }
}
