package top.co4.feign.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author CodeXYW
 * @date 2022/7/2 12:38
 */
@EnableFeignClients
@SpringBootApplication
public class FeignUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignUserServiceApplication.class,args);
    }
}