package com.example.AEPB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ParkingRobot {

    private final List<ParkingLot> parkingLotList = new ArrayList();

    public void managementParkingLot(List<ParkingLot> parkingLots) {
        parkingLotList.addAll(parkingLots);
    }

    public ParkingTicket parking(Car car) {
        if (car == null)
            throw new NullPointerException("you can not give me a null car");

        return  parkingLotList.stream()
                .filter(parkingLot -> parkingLot.getAvailablePosition() > 0).min(Comparator.comparing(ParkingLot::getVacancyRate).reversed()
                        .thenComparing(ParkingLot::getParkingLotNumber)).get().parking(car);
    }
}

