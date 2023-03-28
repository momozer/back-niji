package com.niji.lille.nijiVerse.parkingKafka;

import com.niji.lille.nijiVerse.entities.Parking;
import com.niji.lille.nijiVerse.repositories.ParkingRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
public class KafkaParkingConsumer {

    private ParkingRepository repository;

    @KafkaListener(topics = "parking-topic")
    public void receiveMessage(String message){
        Parking parking = new Parking();
        int places = parking.getPlaces();

        if(message.equals("entrée")){
            places --;
        } else if (message.equals("sortie")){
            places ++;
        }
        parking.setPlaces(places);
        repository.save(parking);
    }
}
