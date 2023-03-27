package com.niji.lille.nijiVerse.parkingKafka;

import com.niji.lille.nijiVerse.entities.Parking;
import com.niji.lille.nijiVerse.repositories.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ParkingConsumer {

    @Autowired
    private ParkingRepository parkingRepository;

    @KafkaListener(topics = "parking-topic")
    public void receiveMessage (String message){
        Parking parking = parkingRepository.getOne(1L);
        int places = parking.getPlace();

        if (message.equals("entree")){
            places--;
        }else if (message.equals("sortie")){
            places++;
        }

        parking.setPlace(places);
        parkingRepository.save(parking);
    }
}
