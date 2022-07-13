package top.co4.consumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author CodeXYW
 * @date 2022/7/12 18:53
 */
@Component
public class SpringRabbitListener {

    /***
     * @Description //TODO 消费端代码
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 8:55
     */
    @RabbitListener(queues = "test.queue_01")
    public void simpleQueue(String msg){
        System.out.println("消费端_01"+msg);
    }

    @RabbitListener(queues = "test.queue_02")
    public void workQueue(String msg){
        System.out.println("消费端_02"+msg);
    }
}
