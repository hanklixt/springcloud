package com.test;

import com.rabbit.RabbitMqTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqTestApplication.class)
public class Produce {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test(){
      rabbitTemplate.convertAndSend("lxt","吃饭了");
    }
}
