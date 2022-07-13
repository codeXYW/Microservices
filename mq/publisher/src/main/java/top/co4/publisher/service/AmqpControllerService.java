package top.co4.publisher.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.co4.publisher.config.RabbitConfig;

/**
 * @author CodeXYW
 * @date 2022/7/13 10:47
 */
@Service
public class AmqpControllerService {

    @Autowired
    RabbitTemplate rabbitTemplate;


    /***
     * @Description //TODO 基本消息队列
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 13:46
     */
    public void basicQueue(String msg){
        rabbitTemplate.convertAndSend(RabbitConfig.BASIC_QUEUE,msg);
    }

    /***
     * @Description //TODO 工作消息队列
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 13:46
     */
    public void workQueue(String msg){
        rabbitTemplate.convertAndSend(RabbitConfig.WORK_QUEUE,msg);
    }

    /***
     * @Description //TODO 发布与定于 fanout
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 13:46
     */
    public void fanoutExchange(String msg){
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE,"",msg);
    }



}
