package top.hastur23.blogServer.mapper;

import top.hastur23.blogServer.entity.MainText;
import org.springframework.stereotype.Repository;

@Repository
public interface TextMapper {
    MainText getBlogText(MainText mainText);

    int insertBlogText(MainText mainText);
}
