package top.co4.feign.user.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.co4.api.clients.UserClient;
import top.co4.api.pojo.User;
import top.co4.feign.user.service.UserService;

@Slf4j
@RestController
public class UserController implements UserClient {
    @Autowired
    private UserService userService;

    @Override
    public User findUserById(String id) {
        return userService.queryById(Long.valueOf(id));
    }
}
