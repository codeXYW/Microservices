package top.co4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.co4.service.BaseControllerService;

/**
 * @author CodeXYW
 * @date 2022/7/12 18:22
 */
@RequestMapping("/base")
@RestController
public class BaseController {
    @Autowired
    BaseControllerService baseControllerService;

    @RequestMapping("/sendMsg")
    public String sendMsg(@RequestParam("msg")String msg){
        baseControllerService.sendFanoutExchange("HelloWorld");
        return "success";
    }
}
