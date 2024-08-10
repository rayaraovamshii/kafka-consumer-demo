package com.vamshilearning.consumer;

import com.vamshilearning.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {


    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);


    @KafkaListener(topics = "topic", groupId = "vamshi-group-3")
    public void consume1(Customer message) {
        log.info("Consumer consume message: {}", message.toString());
    }

    @KafkaListener(topics = "v-topic", groupId = "vamshi-group-2", topicPartitions = {@TopicPartition(topic= "v-topic",
    partitions =  {"2"})})
    public void consume2(String message) {
        log.info("Consumer2 message: {}", message);
    }
//    @KafkaListener(topics = "topicThroughBeanCreation1", groupId = "vamshi-group-2")
//    public void consume3(String message) {
//        log.info("Consumer3 message: {}", message);
//    }
//
//    @KafkaListener(topics = "topicThroughBeanCreation1", groupId = "vamshi-group-2")
//    public void consume4(String message) {
//        log.info("Consumer4 message: {}", message);
//    }
}
