package top.hastur23.blogServer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hastur23.blogServer.entity.User;
import top.hastur23.blogServer.mapper.UserMapper;

public interface UserService {
    User login(User user);
}

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User u = userMapper.login(user);
        if (null != u) {
            log.info("登录成功..");
            return u;
        }
        log.info("登录失败...");
        return null;
    }
}
