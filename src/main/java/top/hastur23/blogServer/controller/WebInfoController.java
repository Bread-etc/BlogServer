package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.entity.WebInfo;
import top.hastur23.blogServer.service.WebInfoService;

@RestController
public class WebInfoController {
    @Autowired
    private WebInfoService webInfoService;

    @PostMapping("/info/webInfo")
    public Response getWebInfo(@RequestBody WebInfo webInfo) {
        try {
            WebInfo result = webInfoService.getWebInfo(webInfo);
            return Response.success(result);
        } catch (Exception e) {
            return Response.failure(500,"获取网页详情失败");
        }
    }
}
