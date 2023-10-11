package top.hastur23.blogServer.mapper;

import top.hastur23.blogServer.entity.WebInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface WebInfoMapper {
    WebInfo getWebInfo(WebInfo webInfo);
}
