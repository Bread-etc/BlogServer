package top.hastur23.blogServer.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import top.hastur23.blogServer.mapper.WebInfoMapper;

import java.util.Date;

@Service
public class WebInfoService {
    @Autowired
    WebInfoMapper webInfoMapper;

    public Date getLastTime() {
        return webInfoMapper.getLastTime();
    }
}
