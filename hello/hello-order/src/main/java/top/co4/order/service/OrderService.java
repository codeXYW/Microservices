package top.co4.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.co4.order.mapper.OrderMapper;
import top.co4.order.pojo.Order;
import top.co4.order.pojo.User;

@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    RestTemplate restTemplate;

    /***
     * @Description //TODO 已过期
     * @Param: [orderId]
     * @Return: top.co4.order.pojo.Order
     * @Author CodeXYW
     * @Date 2022/6/28 20:56
     */
    public Order overdueMethodQueryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.返回
        return order;
    }

    /***
     * @Description //TODO
     * @Param: [orderId]
     * @Return: top.co4.order.pojo.Order
     * @Author CodeXYW
     * @Date 2022/6/28 20:56
     */
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.拼接访问地址
        String url="http://localhost:8081/user/"+order.getUserId();
        log.info(url);
        // 3.获取用户信息
        ResponseEntity<User> user = restTemplate.getForEntity(url, User.class);
        order.setUser(user.getBody());

        // 4.返回
        return order;
    }
}
