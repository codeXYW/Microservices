package top.co4.api.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.co4.api.pojo.Order;

/**
 * @author CodeXYW
 * @date 2022/7/2 14:29
 */
@FeignClient("feign-order")
public interface OrderClient {

    @GetMapping("/order/{orderId}")
    Order queryOrderByUserId(@PathVariable("orderId") Long orderId);
}
