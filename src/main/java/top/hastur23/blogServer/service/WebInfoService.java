package top.hastur23.blogServer.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.hastur23.blogServer.entity.WebInfo;
import top.hastur23.blogServer.mapper.WebInfoMapper;

@Service
public class WebInfoService {
    @Autowired
    WebInfoMapper webInfoMapper;

    public WebInfo getWebInfo(WebInfo webInfo) {
        return webInfoMapper.getWebInfo(webInfo);
    }
}
