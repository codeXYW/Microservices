package top.co4.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.co4.order.pojo.Order;
import top.co4.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

   @Autowired
   private OrderService orderService;

    @GetMapping("/{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }
}
