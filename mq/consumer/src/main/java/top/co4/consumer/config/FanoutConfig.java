package top.co4.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CodeXYW
 * @date 2022/7/13 8:26
 * 创建并绑定 交换机和队列
 * Exchange: 交换机  Queue: 消息队列  Binding: 绑定
 */
@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(RabbitConfig.FANOUT_EXCHANGE);
    }

    @Bean
    public Queue fanoutQueueA(){
        return new Queue(RabbitConfig.FANOUT_QUEUE_A);
    }

    @Bean
    public Queue fanoutQueueB(){
        return new Queue(RabbitConfig.FANOUT_QUEUE_B);
    }

    @Bean
    public Binding fanoutBinding1(FanoutExchange fanoutExchange,Queue fanoutQueueA){
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBinding2(FanoutExchange fanoutExchange,Queue fanoutQueueB){
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }
}
