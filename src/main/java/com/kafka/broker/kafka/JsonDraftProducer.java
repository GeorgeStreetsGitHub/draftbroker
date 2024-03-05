package com.kafka.broker.kafka;

import com.kafka.broker.payload.Draft;
import com.kafka.broker.payload.User;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonDraftProducer
{

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDraftProducer.class);

    private KafkaTemplate<String, Draft> kafkaTemplate;
    public JsonDraftProducer(KafkaTemplate<String, Draft> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Draft draftData){

        LOGGER.info(String.format("JSON DRAFT Message sent - %s", draftData.toString()));

        Message<Draft> message = MessageBuilder
                .withPayload(draftData)
                .setHeader(KafkaHeaders.TOPIC, "draft-testing")
                .build();

        kafkaTemplate.send(message);
    }






}