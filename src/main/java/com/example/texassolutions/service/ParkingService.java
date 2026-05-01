package com.example.texassolutions.service;

import com.example.texassolutions.model.ParkingSpot;
import com.example.texassolutions.model.SpotSize;
import com.example.texassolutions.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    public boolean parkVehicle(Vehicle vehicle) {

        return true;

    }


    public List<ParkingSpot> availableSpots() {
        List<ParkingSpot> parkingSpots = createMockParkingSpot();
        parkingSpots = parkingSpots.stream()
                .filter(parkingSpot -> parkingSpot.isAvailable())
                .collect(Collectors.toList());

        return parkingSpots;
    }



    private List<ParkingSpot> createMockParkingSpot() {
        ParkingSpot parkingSlot = new ParkingSpot();
        Vehicle vehicle = new  Vehicle();
        vehicle.setSpotSize(SpotSize.SMALL);
        vehicle.setLicensePlate("TX1234");

        parkingSlot.setSpotNumber(1);
        parkingSlot.setVehicle(vehicle);
        parkingSlot.setSpotSize(SpotSize.SMALL);
        parkingSlot.setAvailable(true);

        List<ParkingSpot> listParkingSpots = new ArrayList<>();
        listParkingSpots.add(parkingSlot);

        return listParkingSpots;



    }
}
