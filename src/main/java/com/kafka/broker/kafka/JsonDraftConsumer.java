package com.kafka.broker.kafka;

import com.kafka.broker.payload.Draft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class JsonDraftConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDraftConsumer.class);

    @KafkaListener(topics = "draft-testing", groupId = "myGroup")
    public void consume(Draft draft){
        LOGGER.info(String.format("JSON DRAFT Message received -> %s", draft.toString()));
    }
}
