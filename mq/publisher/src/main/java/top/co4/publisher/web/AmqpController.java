package top.co4.publisher.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.co4.publisher.service.AmqpControllerService;

/**
 * @author CodeXYW
 * @date 2022/7/13 10:46
 */
@RequestMapping("/amqp/sender")
@RestController
public class AmqpController {

    @Autowired
    AmqpControllerService amqpControllerService;
    @RequestMapping("/basic")
    public void basic(){
        amqpControllerService.basicQueue("HelloBasicQueue");
    }

    @RequestMapping("/work")
    public void work(){
        amqpControllerService.fanoutExchange("HelloWorkQueue");
    }

    @RequestMapping("/fanout")
    public void fanoutExchange(){
        amqpControllerService.fanoutExchange("HelloFanoutExchange");
    }
}
