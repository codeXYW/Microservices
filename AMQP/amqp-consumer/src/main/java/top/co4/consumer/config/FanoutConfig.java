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
 */
@Configuration
public class FanoutConfig {

    /***
     * @Description //TODO 创建交换机
     * @Param: []
     * @Return: org.springframework.amqp.core.FanoutExchange
     * @Author CodeXYW
     * @Date 2022/7/13 8:29
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("test.code");
    }

    /***
     * @Description //TODO 创建队列 01
     * @Param: []
     * @Return: org.springframework.amqp.core.Queue
     * @Author CodeXYW
     * @Date 2022/7/13 8:31
     */
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("test.queue_01");
    }

    /***
     * @Description //TODO 创建队列 02
     * @Param: []
     * @Return: org.springframework.amqp.core.Queue
     * @Author CodeXYW
     * @Date 2022/7/13 8:31
     */
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("test.queue_02");
    }

    /***
     * @Description //TODO 队列和交换机进行绑定
     * @Param: [fanoutExchange, fanoutQueue1]
     * @Return: org.springframework.amqp.core.Binding
     * @Author CodeXYW
     * @Date 2022/7/13 8:34
     */
    @Bean
    public Binding fanoutBinding1(FanoutExchange fanoutExchange,Queue fanoutQueue1){
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    /***
     * @Description //TODO 队列和交换机进行绑定
     * @Param: [fanoutExchange, fanoutQueue1]
     * @Return: org.springframework.amqp.core.Binding
     * @Author CodeXYW
     * @Date 2022/7/13 8:34
     */
    @Bean
    public Binding fanoutBinding2(FanoutExchange fanoutExchange,Queue fanoutQueue2){
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
