package com.kwok.goods;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
//eureka客户端
@EnableEurekaClient
@RefreshScope
@RestController
public class GoodsApplication {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/from")
    public String hi(){
        return from;
    }

    @Bean
    //支持ribbon
    @LoadBalanced
    public RestTemplate getRestTamplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
