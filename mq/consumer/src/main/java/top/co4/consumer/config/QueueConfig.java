package top.co4.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author CodeXYW
 * @date 2022/7/13 13:26
 */
@Component
public class QueueConfig {
    @Bean
    public Queue workQueue(){
        return new Queue(RabbitConfig.WORK_QUEUE);
    }

    @Bean
    public Queue basicQueue(){
        return new Queue(RabbitConfig.BASIC_QUEUE);
    }

    @Bean
    public Queue objectQueue(){
        return new Queue(RabbitConfig.QUEUE);
    }
}
