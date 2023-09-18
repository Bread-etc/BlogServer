package top.hastur23.blogServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* @author: bread_etc
* @since: 2023/09/17 23:19
* */

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello, spingboot3!";
    }
}
