package top.hastur23.blogServer.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.hastur23.blogServer.entity.AliasInfo;
import top.hastur23.blogServer.mapper.AliasInfoMapper;

@Service
public class TextService {
    @Autowired
    AliasInfoMapper aliasInfoMapper;

    public AliasInfo getBlogText(AliasInfo aliasInfo) {
        return aliasInfoMapper.getBlogText(aliasInfo);
    }

    public int insertBlogText(AliasInfo aliasInfo) {
        return aliasInfoMapper.insertBlogText(aliasInfo);
    }
}