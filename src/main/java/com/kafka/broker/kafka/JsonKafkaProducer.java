package com.kafka.broker.kafka;

import com.kafka.broker.payload.User;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User userData){

        LOGGER.info(String.format("JSON Message sent - %s", userData.toString()));

        Message<User> message = MessageBuilder
                .withPayload(userData)
                .setHeader(KafkaHeaders.TOPIC, "user-testing")
                .build();

        kafkaTemplate.send(message);
    }






}
