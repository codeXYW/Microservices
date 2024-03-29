package top.co4.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaOrderServiceApplication.class, args);
    }

}
