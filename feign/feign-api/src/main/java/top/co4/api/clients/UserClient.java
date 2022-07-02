package top.co4.api.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.co4.api.config.MyFeignConfig;
import top.co4.api.pojo.User;


/**
 * @author CodeXYW
 * @date 2022/7/2 12:48
 */
@FeignClient(value = "feign-user",configuration = MyFeignConfig.class)
public interface UserClient {

    @GetMapping("/user/{id}")
    User findUserById(@PathVariable("id")String id);
}
