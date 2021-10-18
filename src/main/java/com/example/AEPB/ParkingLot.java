package com.example.AEPB;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    int position = 50;

    private final Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingTicket parking(Car car) {
        if (car == null)
            throw new NullPointerException("car should not be null");
        if (ticketCarMap.containsValue(car))
            throw new IllegalArgumentException("car should not be parking twice");
        if (position <= 0)
            throw new IllegalArgumentException("position is not enough");

        ParkingTicket parkingTicket = new ParkingTicket();
        ticketCarMap.put(parkingTicket, car);
        position -= 1;
        return parkingTicket;
    }

    public int getAvailablePosition() {
        return position;
    }

    public Car pickUp(ParkingTicket parkingTicket) {
        if (!ticketCarMap.containsKey(parkingTicket)) {
            throw new IllegalArgumentException("invalid parking ticket");
        }
        Car car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        position += 1;
        return car;
    }
}
