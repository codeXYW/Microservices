package top.co4.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author CodeXYW
 * @date 2022/7/2 18:10
 */
@Slf4j
@Component
@Order(-1)//优先级
public class AuthorizeFilter implements GlobalFilter {

    //Mono属于webfuxl的参数与普通的MVC参数有所不同
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {



        //取出请求体
        ServerHttpRequest request = exchange.getRequest();
        //取出请求头
        HttpHeaders headers = request.getHeaders();

        List<String> cookie = headers.get("Cookie");

        if (cookie!=null){
            log.info(cookie.get(0).split(";")[1]);
            //放行
            return chain.filter(exchange);
        }
        //设置响应code
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        //拦截
        return exchange.getResponse().setComplete();
    }

}
