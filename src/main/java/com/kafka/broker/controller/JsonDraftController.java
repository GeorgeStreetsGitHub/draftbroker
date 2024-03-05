package com.kafka.broker.controller;

import com.kafka.broker.kafka.JsonDraftProducer;
import com.kafka.broker.payload.Draft;
import com.kafka.broker.payload.Payload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka/draft")
public class JsonDraftController {

    Logger LOGGER = LoggerFactory.getLogger(JsonDraftController.class);

    private JsonDraftProducer jsonDraftProducer;

    public JsonDraftController(JsonDraftProducer jsonDraftProducer) {
        this.jsonDraftProducer = jsonDraftProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Payload payload){
        Draft draft = payload.getDraft();
        jsonDraftProducer.sendMessage(draft);
        return ResponseEntity.ok("Draft Message sent to topic");
    }

}
