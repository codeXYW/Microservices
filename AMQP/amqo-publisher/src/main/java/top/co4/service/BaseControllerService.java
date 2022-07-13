package top.co4.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CodeXYW
 * @date 2022/7/12 18:22
 */
@Service
public class BaseControllerService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /***
     * @Description //TODO 往已有的消息队列中发送消息
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/12 18:46
     */
    public void sendQueue(String msg){
        rabbitTemplate.convertAndSend("simple.queue",msg);
    }

    /***
     * @Description //TODO 循环发送模拟用户请求 每发送50次休息一秒钟（WorkQueue）
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/12 19:22
     */
    public void sendWorkQueue(String msg){
        int i=0;
        while (true){
            ++i;
            rabbitTemplate.convertAndSend("simple.queue",msg+i);
            if (i%50==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    /***
     * @Description //TODO 通过交换机发送
     * @Param: [msg]
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 8:41
     */
    public void sendFanoutExchange(String msg){
        String exchangeName="test.code";
        rabbitTemplate.convertAndSend(exchangeName,"",msg);
    }
}
