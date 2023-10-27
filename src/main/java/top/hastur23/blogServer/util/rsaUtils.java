package top.hastur23.blogServer.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class rsaUtils {
    public static final String ENCRYPT_TYPE = "RSA";

    // 公钥
    public static final String PUBLIC_KEY = "";
    // 私钥
    private static final String PRIVATE_KEY = "";

    public static void main(String[] args) {
        generateKey();
        String content = "loginTest测试";
        String encrypt = rsaUtils.encrypt(content, PUBLIC_KEY);
        String decrypt = rsaUtils.decrypt(encrypt);
        System.out.println(decrypt);
    }

    // 替换秘钥
    public static void generateKey() {
        Map<String, String> stringStringMap = rsaUtils.generateKeyPair();

        String RSAPublicKey = stringStringMap.get("PUBLIC_KEY");
        String RSAPrivateKey = stringStringMap.get("PRIVATE_KEY");
        System.out.println(RSAPublicKey);
        System.out.println("**********");
        System.out.println(RSAPrivateKey);
    }

    // 生成密钥对
    public static Map<String, String> generateKeyPair() {
        try {
            KeyPair pair = SecureUtil.generateKeyPair(ENCRYPT_TYPE);
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();
            // 获取 公钥和私钥 的编码格式(通过编码格式可以反过来生成公钥和私钥对)
            byte[] pubEncBytes = publicKey.getEncoded();
            byte[] priEncBytes = privateKey.getEncoded();

            // 把公钥和私钥的编码格式转换为 Base64 文本,便于保存
            String pubEncBase64 = Base64.getEncoder().encodeToString(pubEncBytes);
            String priEncBase64 = Base64.getEncoder().encodeToString(priEncBytes);

            Map<String, String> map = new HashMap<String, String>(2);
            map.put("PUBLIC_KEY", pubEncBase64);
            map.put("PRIVATE_KEY", priEncBase64);

            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
    * 公钥加密
    *
    * @param content 加密内容
    * @param publicKey 公钥
    * */
    public static String encrypt(String content, String publicKey) {
        try {
            RSA rsa = new RSA(null, publicKey);
            return rsa.encryptBase64(content, KeyType.PublicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥解密
     *
     * @param content 要解密的内容
     */
    public static String decrypt(String content) {
        try {
            RSA rsa = new RSA(PRIVATE_KEY, null);
            return rsa.decryptStr(content, KeyType.PrivateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
