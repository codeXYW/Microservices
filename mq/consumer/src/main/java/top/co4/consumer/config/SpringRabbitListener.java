package top.co4.consumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author CodeXYW
 * @date 2022/7/12 18:53
 * 自动注入进Spring中开启订阅模式
 */
@Component
public class SpringRabbitListener {

    @RabbitListener(queues = RabbitConfig.BASIC_QUEUE)
    public void basicQueue(String msg){
        System.out.println("BASIC_QUEUE_MSG:  "+msg);
    }

    @RabbitListener(queues = RabbitConfig.WORK_QUEUE)
    public void workQueueOne(String msg){
        System.out.println("WORK_QUEUE_MSG_01:  "+msg);
    }

    @RabbitListener(queues = RabbitConfig.WORK_QUEUE)
    public void workQueueTwo(String msg){
        System.out.println("WORK_QUEUE_MSG_02:  "+msg);
    }

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_A)
    public void fanoutQueueA(String msg){
        System.out.println("FANOUT_QUEUE_A_MSG:  "+msg);
    }

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE_B)
    public void fanoutQueueB(String msg){
        System.out.println("FANOUT_QUEUE_B_MSG:  "+msg);
    }
}
