package top.co4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.co4.service.BaseControllerService;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author CodeXYW
 * @date 2022/7/12 18:22
 */
@RequestMapping("/base")
@RestController
public class BaseController {

    @Autowired
    BaseControllerService baseControllerService;

    @GetMapping("/simple")
    public void simple() throws IOException, TimeoutException {
        baseControllerService.simple();
    }

    @GetMapping("/fanout")
    public void fanout() throws IOException, TimeoutException {
        baseControllerService.fanout();
    }

    @GetMapping("/direct")
    public void direct() throws IOException, TimeoutException {
        baseControllerService.direct();
    }

    @GetMapping("/topic")
    public void topic() throws IOException, TimeoutException {
        baseControllerService.topic();
    }

    @GetMapping("/headers")
    public void headers() throws IOException, TimeoutException {
        baseControllerService.headers();
    }
}
