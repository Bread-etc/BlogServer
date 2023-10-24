package top.hastur23.blogServer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("/api/login")
    // 用于封装随机产生的公钥与私钥
    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();
    public static void main(String[] args) throws Exception {
        // 生成公钥和私钥
        genKeyPair();
        // 加密字符串
        String message = "bread_etc";
        System.out.println("随机生成的公钥为:" + keyMap.get(0));
        System.out.println("随机生成的私钥为:" + keyMap.get(1));
        String messageEn = encrypt(message, keyMap.get(0));
        System.out.println("加密前的字符串为:" + messageEn);
        System.out.println("加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn, keyMap.get(1));
        System.out.println("还原后的字符串为:" + messageDe);
    }
}
