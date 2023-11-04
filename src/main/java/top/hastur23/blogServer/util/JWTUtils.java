package top.hastur23.blogServer.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JWTUtils {
    // 有效时间为 3天
    private static long expirationTime = 1000 * 60 * 60 * 24 * 3;
    private static SecretKey signatrue = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static String createToken(String username){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // payload
                .claim("username", username)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                // signatrue
                .signWith(SignatureAlgorithm.HS256, signatrue)
                .compact();
        return jwtToken;
    }

    // 验证 token 有效性
    public static boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(signatrue)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return !claims.getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            return false;
        }
    }
}