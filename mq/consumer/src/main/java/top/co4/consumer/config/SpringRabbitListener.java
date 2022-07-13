package top.co4.consumer.config;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author CodeXYW
 * @date 2022/7/12 18:53
 * 自动注入进Spring中开启订阅模式
 */
@Component
public class SpringRabbitListener {

    //基本消息队列
    @RabbitListener(queues = RabbitConfig.BASIC_QUEUE)
    public void basicQueue(String msg){
        System.out.println("BASIC_QUEUE_MSG:  "+msg);
    }

    //工作消息队列 one
    @RabbitListener(queues = RabbitConfig.WORK_QUEUE)
    public void workQueueOne(String msg){
        System.out.println("WORK_QUEUE_MSG_01:  "+msg);
    }

    //工作消息队列 two
    @RabbitListener(queues = RabbitConfig.WORK_QUEUE)
    public void workQueueTwo(String msg){
        System.out.println("WORK_QUEUE_MSG_02:  "+msg);
    }

    //发布与订阅 fanout A
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_A)
    public void fanoutQueueA(String msg){
        System.out.println("FANOUT_QUEUE_A_MSG:  "+msg);
    }

    //发布与订阅 fanout B
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_B)
    public void fanoutQueueB(String msg){
        System.out.println("FANOUT_QUEUE_B_MSG:  "+msg);
    }

    //全新写法 发布与订阅 direct A
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitConfig.DIRECT_QUEUE_A),
            exchange = @Exchange(name = RabbitConfig.DIRECT_EXCHANGE,type = ExchangeTypes.DIRECT),
            key = {"one","tow"}
    ))
    public void directQueueOne(String msg){
        System.out.println("DIRECT_QUEUE_A_MSG:  "+msg);
    }

    //全新写法 发布与订阅 direct B
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitConfig.DIRECT_QUEUE_B),
            exchange = @Exchange(name = RabbitConfig.DIRECT_EXCHANGE,type = ExchangeTypes.DIRECT),
            key = {"tow","three"}
    ))
    public void directQueueTwo(String msg){
        System.out.println("DIRECT_QUEUE_B_MSG:  "+msg);
    }

    //发布与订阅 topic A
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitConfig.TOPIC_QUEUE_A),
            exchange = @Exchange(name = RabbitConfig.TOPIC_EXCHANGE,type = ExchangeTypes.TOPIC),
            key ="user.#" //topic.# == topic.a.b.c.d.all
    ))
    public void topicQueueA(String msg){
        System.out.println("TOPIC_QUEUE_A_MSG:  "+msg);
    }

    //发布与订阅 topic B
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitConfig.TOPIC_QUEUE_B),
            exchange = @Exchange(name = RabbitConfig.TOPIC_EXCHANGE,type = ExchangeTypes.TOPIC),
            key ="#.user" //#.topic == a.b.c.d.all.topic
    ))
    public void topicQueueB(String msg){
        System.out.println("TOPIC_QUEUE_B_MSG:  "+msg);
    }

    //发布与订阅 topic C
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = RabbitConfig.TOPIC_QUEUE_C),
            exchange = @Exchange(name = RabbitConfig.TOPIC_EXCHANGE,type = ExchangeTypes.TOPIC),
            key ="*.user" // topic.* == topic.a
    ))
    public void topicQueueC(String msg){
        System.out.println("TOPIC_QUEUE_C_MSG:  "+msg);
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void objectQueue(Object value){
        System.out.println(value);
    }
}
