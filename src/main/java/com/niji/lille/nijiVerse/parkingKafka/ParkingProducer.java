package com.niji.lille.nijiVerse.parkingKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ParkingProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String message){
        kafkaTemplate.send("place de parking : ", message);
    }
}
