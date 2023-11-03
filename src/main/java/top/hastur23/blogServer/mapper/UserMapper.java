package top.hastur23.blogServer.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.hastur23.blogServer.entity.User;

@Mapper
public interface UserMapper {
    User login(User user);
}
