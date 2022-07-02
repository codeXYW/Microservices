package top.co4.user.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import top.co4.user.config.PatternProperties;
import top.co4.user.pojo.User;
import top.co4.user.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    PatternProperties properties;
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        log.info("请求ID:{}",id);
        return userService.queryById(id);
    }

    @GetMapping("/getProperties")
    public PatternProperties getProperties(){
        return properties;
    }





}
