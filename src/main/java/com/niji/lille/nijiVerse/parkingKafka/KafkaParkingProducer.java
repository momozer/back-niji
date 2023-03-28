package com.niji.lille.nijiVerse.parkingKafka;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@EnableKafka
public class KafkaParkingProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String message){
        kafkaTemplate.send("parking-topic", message);
    }
}
