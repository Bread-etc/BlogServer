package top.hastur23.blogServer.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.hastur23.blogServer.entity.MainText;
import top.hastur23.blogServer.mapper.TextMapper;

@Service
public class TextService {
    @Autowired
    TextMapper textMapper;

    public MainText getBlogText(MainText mainText) {
        return textMapper.getBlogText(mainText);
    }
}