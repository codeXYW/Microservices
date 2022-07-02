package top.co4.feign.user.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.co4.api.pojo.User;
import top.co4.feign.user.service.UserService;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
