package com.example.AEPB;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private final List<ParkingLot> parkingLotList = new ArrayList();

    public void managementParkingLot(List<ParkingLot> parkingLots) {
        parkingLotList.addAll(parkingLots);
    }

    public ParkingTicket parkingCar(Car car) {
        if (car == null)
            throw new NullPointerException("you can not give me a null car");

        ParkingLot canParkingParkingLot = parkingLotList.stream()
                                                        .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                                                        .findFirst()
                                                        .orElseThrow(() -> new IllegalAccessError("parkingLot is not enough"));
        return canParkingParkingLot.parking(car);
    }

    public Car pickUpCar(ParkingTicket parkingTicket) {
        Car car = null;
        for (ParkingLot parkingLot : parkingLotList) {
            try {
                car = parkingLot.pickUp(parkingTicket);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        if (car == null)
            throw new IllegalAccessError("this parking ticket is invalid");
        return car;
    }
}
