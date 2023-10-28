package top.hastur23.blogServer.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class rsaUtils {
    // 规定加密类型 (非对称加密)
    public static final String ENCRYPT_TYPE = "RSA";

    // 生成密钥对
    public static Map<String, String> generateKeyPair() {
        try {
            // 自助生成 RSA 秘钥对
            KeyPair pair = SecureUtil.generateKeyPair(ENCRYPT_TYPE);
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();
            // 获取 公钥和私钥 的编码格式
            byte[] pubEncBytes = publicKey.getEncoded();
            byte[] priEncBytes = privateKey.getEncoded();

            // 把公钥和私钥的编码格式转换为 Base64 文本,便于保存
            String pubEncBase64 = Base64.getEncoder().encodeToString(pubEncBytes);
            String priEncBase64 = Base64.getEncoder().encodeToString(priEncBytes);

            // 初始化哈希表, 初始容量为2
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
    * 公钥加密 (encrypt)
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
     * 私钥解密 (decrypt)
     *
     * @param content 要解密的内容
     * @param privateKey 私钥
     */
    public static String decrypt(String content, String privateKey) {
        try {
            RSA rsa = new RSA(privateKey, null);
            return rsa.decryptStr(content, KeyType.PrivateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
