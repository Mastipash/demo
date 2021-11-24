package com.example.demo.service;

import com.example.demo.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Document;

import java.time.LocalTime;

@Service
@Slf4j
public class Producer {
    private static final String TOPIC = "orders";
    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<Long, Order> kafkaTemplate;

    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    public  void send() {
        Order order = createOrder();
        kafkaTemplate.send(TOPIC, order);
        logger.info(String.format("#### -> Consumed message -> %s", order));
    }

    private Order createOrder() {
        Order order = new Order(
                ("ordNo-" + (int)(Math.random()*(10000000-50))+50),
                (int)(Math.random()*(5-1)+1),
                (int)(Math.random()*(15-1)+1),
                        1,
                (int)(Math.random()*(4-1)+1)
        );

        return order;
    }
}
