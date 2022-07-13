package top.co4.publisher.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.co4.publisher.service.PublisherBaseControllerService;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author CodeXYW
 * @date 2022/7/12 18:22
 */
@RequestMapping("/base/sender")
@RestController
public class PublisherBaseController {

    @Autowired
    PublisherBaseControllerService publisherBaseControllerService;

    @GetMapping("/simple")
    public void simple() throws IOException, TimeoutException {
        publisherBaseControllerService.simple();
    }

    @GetMapping("/fanout")
    public void fanout() throws IOException, TimeoutException {
        publisherBaseControllerService.fanout();
    }

    @GetMapping("/direct")
    public void direct() throws IOException, TimeoutException {
        publisherBaseControllerService.direct();
    }

    @GetMapping("/topic")
    public void topic() throws IOException, TimeoutException {
        publisherBaseControllerService.topic();
    }

    @GetMapping("/headers")
    public void headers() throws IOException, TimeoutException {
        publisherBaseControllerService.headers();
    }
}
