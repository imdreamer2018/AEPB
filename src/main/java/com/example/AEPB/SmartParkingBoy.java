package com.example.AEPB;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy {

    private final List<ParkingLot> parkingLotList = new ArrayList();

    public void managementParkingLot(List<ParkingLot> parkingLots) {
        parkingLotList.addAll(parkingLots);
    }

    public ParkingTicket parkingCar(Car car) {
        return new ParkingTicket();
    }

    public Car pickUpCar(ParkingTicket parkingTicket) {
        return new Car();
    }
}
