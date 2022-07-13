package top.co4.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.co4.consumer.service.BaseControllerService;

import java.io.IOException;

/**
 * @author CodeXYW
 * @date 2022/7/13 11:13
 */
@RequestMapping("/base/receiver")
@RestController
public class BaseController {

    @Autowired
    BaseControllerService baseControllerService;

    @GetMapping("/simple")
    public void simple() throws IOException {
        baseControllerService.simple();
    }

    @GetMapping("/fanout")
    public void fanout(){
        baseControllerService.fanout();
    }


    @GetMapping("/direct")
    public void direct(){
        baseControllerService.direct();
    }


    @GetMapping("/topic")
    public void topic(){
        baseControllerService.topic();
    }


    @GetMapping("/headers")
    public void headers(){
        baseControllerService.headers();
    }




}
