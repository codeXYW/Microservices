package top.co4.feign.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.co4.api.clients.UserClient;

import top.co4.api.pojo.Order;
import top.co4.api.pojo.User;
import top.co4.feign.order.mapper.OrderMapper;

@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserClient userClient;

    /***
     * @Description //TODO
     * @Param: [orderId]
     * @Return: top.co4.order.pojo.Order
     * @Author CodeXYW
     * @Date 2022/6/28 20:56
     */
    public Order queryOrderById(Long orderId) {
        //查询订单
        Order order = orderMapper.findById(orderId);

        log.info(order.toString());

        //查询用户
        User user = userClient.findUserById(order.getUserId());

        //存值
        order.setUser(user);

        //返回
        return order;
    }
}
