import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author CodeXYW
 * @date 2022/7/12 16:30
 */
public class ConsumerTest {
    
    /***
     * @Description //TODO 连接工厂
     * @Param: 
     * @Return: 
     * @Author CodeXYW
     * @Date 2022/7/13 9:05
     */
    static ConnectionFactory factory = new ConnectionFactory();

    static {
        //设置连接参数，分别是：主机名、端口号、vhost、用户名、密码
        factory.setHost("192.168.81.128");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("test");
        factory.setPassword("123456");
    }
    
    public static void main(String[] args) throws IOException, TimeoutException {
        helloRabbitmq();
    }

    /***
     * @Description //TODO 官方案例01 HelloWorld
     * @Param: []
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 9:06
     */
    public static void helloRabbitmq() throws IOException, TimeoutException {
        //建立连接
        Connection connection = factory.newConnection();
        //创建通道Channel
        Channel channel = connection.createChannel();
        //消息队列名称
        String queueName = "test.queue_01";
        //创建消息队列
        channel.queueDeclare(queueName, false, false, false, null);
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) {
                // 5.处理消息
                String message = new String(body);
                System.out.println("接收到消息：[" +  message + "]");
            }
        });
        System.err.println("==================订阅程序启动==================");
    }

    /***
     * @Description //TODO 官方案例03 FanoutExchange
     * @Param: []
     * @Return: void
     * @Author CodeXYW
     * @Date 2022/7/13 9:06
     */
    public static void fanoutExchange() throws IOException, TimeoutException {
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queueName = "test.queue_01";
        //交换机名称
        String exchangeName = "test.code";
        //创建交换机
        channel.exchangeDeclare(exchangeName, "fanout");
        //创建消息队列
        channel.queueDeclare(queueName, false, false, false, null);
        //交换机和消息队列进行绑定
        channel.queueBind(queueName, exchangeName, "");
        // 4.订阅消息 会一直保持连接
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) {
                // 5.处理消息
                String message = new String(body);
                System.out.println("接收到消息：[" + message + "]");
            }
        });
        System.err.println("==================订阅程序启动==================");
    }
}
