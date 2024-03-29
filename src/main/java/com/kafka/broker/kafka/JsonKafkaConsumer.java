package com.kafka.broker.kafka;

import com.kafka.broker.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "user-testing", groupId = "myGroup")
    public void consumer(User user){
        LOGGER.info(String.format("JSON Message received -> %s", user.toString()));
    }
}
