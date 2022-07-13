package top.co4.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.co4.consumer.service.ConsumerBaseControllerService;

import java.io.IOException;

/**
 * @author CodeXYW
 * @date 2022/7/13 11:13
 */
@RequestMapping("/base/receiver")
@RestController
public class ConsumerBaseController {

    @Autowired
    ConsumerBaseControllerService consumerBaseControllerService;

    @GetMapping("/simple")
    public void simple() throws IOException {
        consumerBaseControllerService.simple();
    }

    @GetMapping("/fanout")
    public void fanout(){
        consumerBaseControllerService.fanout();
    }


    @GetMapping("/direct")
    public void direct(){
        consumerBaseControllerService.direct();
    }


    @GetMapping("/topic")
    public void topic(){
        consumerBaseControllerService.topic();
    }


    @GetMapping("/headers")
    public void headers(){
        consumerBaseControllerService.headers();
    }
}
