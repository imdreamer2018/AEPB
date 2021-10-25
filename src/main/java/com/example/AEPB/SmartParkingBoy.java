package com.example.AEPB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {

    private final List<ParkingLot> parkingLotList = new ArrayList();

    public void managementParkingLot(List<ParkingLot> parkingLots) {
        parkingLotList.addAll(parkingLots);
    }

    public ParkingTicket parkingCar(Car car) {
        if (car == null)
            throw new NullPointerException("you can not give me a null car");
        return parkingLotList.stream()
                             .min(Comparator.comparing(ParkingLot::getAvailablePosition)
                                                     .reversed()
                                                     .thenComparing(ParkingLot::getParkingLotNumber))
                             .get().parking(car);



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
