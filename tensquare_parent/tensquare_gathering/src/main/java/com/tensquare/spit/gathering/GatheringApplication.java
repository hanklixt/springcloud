package com.tensquare.spit.gathering;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@MapperScan("com.tensquare.gathering.mapper")
@SpringBootApplication
public class GatheringApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,6);
    }

}
