package com.niji.lille.nijiVerse.dto;

import com.niji.lille.nijiVerse.entities.Parking;
import lombok.Builder;
import lombok.Data;

@Builder @Data
public class ParkingDTO {
    private Long id;
    private Integer places;
    private String occupant;

    public static ParkingDTO fromEntity(Parking parking){
        if (parking == null){
            return null;
        }
        return ParkingDTO.builder().build();
    }

    public static Parking toEntity(ParkingDTO parkingDTO){
        if (parkingDTO == null){
            return null;
        }
        Parking parking = new Parking();
        parking.setPlaces(parkingDTO.getPlaces());
        parking.setOccupant(parkingDTO.getOccupant());

        return parking;
    }
}
