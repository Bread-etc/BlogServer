package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.service.WebInfoService;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class WebInfoController {
    @Autowired
    private WebInfoService webInfoService;

    @GetMapping("/getLastTime")
    public Response getLastTime() {
        try {
            Date result = webInfoService.getLastTime();
            return Response.success(result);
        } catch (Exception e) {
            return Response.failure(500, "获取最后更新时间失败");
        }
    }
}
