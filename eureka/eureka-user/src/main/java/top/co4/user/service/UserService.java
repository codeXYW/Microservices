package top.co4.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.co4.user.mapper.UserMapper;
import top.co4.user.pojo.User;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {

        return userMapper.findById(id);
    }
}