package top.co4.feign.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.co4.api.clients.OrderClient;
import top.co4.api.pojo.Order;
import top.co4.feign.order.service.OrderService;


@RestController
public class OrderController implements OrderClient {

   @Autowired
   private OrderService orderService;

    @Override
    public Order queryOrderByUserId(Long orderId) {
        return orderService.queryOrderById(orderId);
    }
}
