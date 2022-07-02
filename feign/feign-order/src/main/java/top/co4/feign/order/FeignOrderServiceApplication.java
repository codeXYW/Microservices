package top.co4.feign.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import top.co4.api.clients.UserClient;

/**
 * @author CodeXYW
 * @date 2022/7/2 12:37
 */
@EnableFeignClients(clients = {UserClient.class})
@SpringBootApplication
public class FeignOrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderServiceApplication.class,args);
    }
}
