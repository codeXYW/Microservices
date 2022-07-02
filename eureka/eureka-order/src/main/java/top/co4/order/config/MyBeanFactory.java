package top.co4.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author CodeXYW
 * @date 2022/6/28 20:38
 */
@Configuration
public class MyBeanFactory {


    /**
     * @Description //TODO 向容器中注册一个 RestTemplate Bean
     * @Param:
     * @Return:
     * @Author CodeXYW
     * @Date 2022/6/28 20:58
     */
    @Configuration
    static class MyRestTemplate{
        @Bean
        @LoadBalanced
        public RestTemplate getRestTemplate(){
            return new RestTemplate();
        }
    }
//采用普通轮询的方式，容易出现服务不存在的问题
//    @Configuration
//    static class  MyIRule{
//        @Bean
//        public IRule iRule(){
//            return new RoundRobinRule();
//        }
//    }
}
