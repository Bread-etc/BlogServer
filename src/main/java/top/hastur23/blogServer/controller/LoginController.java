package top.hastur23.blogServer.controller;

//import top.hastur23.blogServer.util.rsa.RSAEncrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class LoginController {

    @PostMapping("/admin/userAuth")
    public ResponseEntity<String> userAuth(@RequestBody Map<String, String> request) {
        String encryptedUserInfo = request.get("userInfo");

        try {
            // 私钥
            String privateKey = "MIICXQIBAAKBgQDw/IbyO/S8BmMXAUIAf9m0PV/7jkSxXuHh77mhaOYnaWO1/iUj\n" +
                    "8telrsBTFU2U0s71+RwR4vbNjX8ceo1W32a535sH9c+KzeBM8rKRSu+6j9lQ8yRY\n" +
                    "1KFKjVGueFQ5V6pkV0oJuRHrbrWOiKMbh1ceX/VB465HzLtaxt6BuAAcCQIDAQAB\n" +
                    "AoGBAIrK1inTMCvOfel09v90ovz00EAAez2wiOXofIAi+1M9lojtu5RNu7eXwvrW\n" +
                    "7RzGoR33gBwpHL3cPZY4Wwjql61djOm3kzuZAZzxVEqSOC226/BpzFAcb9OhJJU2\n" +
                    "kFeK0YX3OQlylqko2u1S93ClPxTrErSrMelEAG2PrVg04MoBAkEA/2hCUP9Rsy0A\n" +
                    "NXjyuo84lfwJzJ9rpsf+tIia6i38h7MC8Ww0jGZjBLxZ3Ua6kyvctss2dJCB3KGb\n" +
                    "bxX6CGRvQQJBAPGLs1JEAqB15/6UCR/3yeHDITK8coyNH4mzpgTszAw/WXiXtJS+\n" +
                    "m0dqsZSrL3+89fEIWgdV5p2pwpkEQ1T2QskCQHl7Wa+1AWM8EFFeyfU6kiukyfRu\n" +
                    "D4IwtlGgeC7S2L6iws+aLBRrzsU94XCCZ9QAlObNGYWwBlSu+YOI7Hh5bQECQB2q\n" +
                    "a7ax1aTBdmHE6q37b9cDcSNbE7KBbpsp7jzynEjwyttNvob6NfX6e57nu2iz23zj\n" +
                    "6rK18SHyBI1ogaCAskkCQQDUyPHeeYYSCQJ+NQdEtvOWJrvkzmDdUDJb3xVFS9KG\n" +
                    "fvvMkqTApK0No5gfqGKLUUF7Ug80i1E7jdnX1GQ7braR";

            // 解密用户信息
            String userInfo = RSAEncrypt.decrypt(encryptedUserInfo, privateKey);

            // userInfo 应该为一个JSON 字符串, 包含加密后的用户名和密码

            return ResponseEntity.ok("login success!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login fail!");
        }
    }
}
