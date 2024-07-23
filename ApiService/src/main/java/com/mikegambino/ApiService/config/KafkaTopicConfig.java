package com.mikegambino.ApiService.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public NewTopic patientTopic() {
        return TopicBuilder.name("patients").build();
    }

    public NewTopic doctorTopic() {
        return TopicBuilder.name("doctors").build();
    }

    public NewTopic appointmentTopic() {
        return TopicBuilder.name("appointments").build();
    }

}
