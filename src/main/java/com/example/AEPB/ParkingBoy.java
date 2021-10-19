package com.example.AEPB;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private final List<ParkingLot> parkingLotList = new ArrayList<>();

    public void managementParkingLot(List<ParkingLot> parkingLots) {
        parkingLotList.addAll(parkingLots);
    }

    public ParkingTicket parkingCar(Car car) {
        ParkingLot canParkingParkingLot = parkingLotList.stream().filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                                                            .findFirst()
                                                            .orElseThrow(() -> new IllegalAccessError("parkingLot is not enough"));
        return canParkingParkingLot.parking(car);
    }
}
