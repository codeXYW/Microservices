package top.co4.publisher.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.co4.publisher.config.RabbitConfig;

import java.util.HashMap;
import java.util.Map;

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
     * @Description //TODO 发布与订阅 fanout
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 13:46
     */
    public void fanoutExchange(String msg){
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE,"",msg);
    }

    /***
     * @Description //TODO 发布与订阅 direct
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 13:46
     */
    public void directExchange(String msg){
        rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE,msg,"HelloDirectExchange");
    }

    /***
     * @Description //TODO 发布与订阅 topic
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 13:46
     */
    public void topicExchange(String msg){
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE,msg,"HelloTopicExchange__"+msg);
    }

    /***
     * @Description //TODO 消息转换器
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 13:46
     */
    public void objectQueue(){
        Map<String,String > map=new HashMap<>();
        map.put("name","CodeXYW");
        map.put("age","100");
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE,map);
    }

}
