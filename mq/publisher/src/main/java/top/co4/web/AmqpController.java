package top.co4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.co4.service.AmqpControllerService;

/**
 * @author CodeXYW
 * @date 2022/7/13 10:46
 */
@RequestMapping("/amqp")
@RestController
public class AmqpController {

    @Autowired
    AmqpControllerService amqpControllerService;

    @RequestMapping("/sendMsg")
    public String sendMsg(@RequestParam("msg")String msg){
        amqpControllerService.sendFanoutExchange("HelloWorld");
        return "success";
    }
}
