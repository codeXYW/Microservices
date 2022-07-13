package top.co4.consumer.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author CodeXYW
 * @date 2022/7/13 10:43
 */
@Component
public class RabbitConfig {

    public static final String QUEUE = "queue_a";

    public static final String BASIC_QUEUE = "basic_queue";

    public static final String WORK_QUEUE = "work_queue";

    public static final String FANOUT_EXCHANGE = "fanout.exchange";
    public static final String FANOUT_QUEUE_A = "fanout_queue_a";
    public static final String FANOUT_QUEUE_B = "fanout_queue_b";

    public static final String DIRECT_EXCHANGE = "direct.exchange";
    public static final String DIRECT_QUEUE_A = "direct_queue_a";
    public static final String DIRECT_QUEUE_B = "direct_queue_b";

    public static final String TOPIC_EXCHANGE = "topic.exchange";
    public static final String TOPIC_QUEUE_A = "topic_queue_a";
    public static final String TOPIC_QUEUE_B = "topic_queue_b";
    public static final String TOPIC_QUEUE_C = "topic_queue_c";

    public static final String HEADER_EXCHANGE = "header.exchange";
    public static final String HEADER_QUEUE_A = "header_queue_a";
    public static final String HEADER_QUEUE_B = "header_queue_b";

    // 获取RabbitMQ服务器连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.81.128");
            factory.setPort(5672);
            factory.setUsername("test");
            factory.setPassword("123456");
            factory.setVirtualHost("/");
            connection = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}