package com.tensquare.spit.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import util.IdWorker;

@SpringBootApplication
//@EnableSwagger2
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,4);
    }

    @Bean
    public RedisTemplate redisTemplate(){
        return new RedisTemplate();
    }
}
