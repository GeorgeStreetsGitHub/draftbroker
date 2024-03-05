package com.kafka.broker.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topicForWorkflow(){
         return TopicBuilder.name("draftconfig")
                 .build();
    }

    @Bean
    public NewTopic JsonTopicForWorkflow(){
        return TopicBuilder.name("draftconfig_json")
                .build();
    }

    @Bean
    public NewTopic JsonDraftTopicForWorkflow(){
        return TopicBuilder.name("draft-testing")
                .build();
    }

}
