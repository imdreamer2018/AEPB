package com.example.AEPB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingBoyTests {

    private ParkingLot parkingLot1 = null;
    private ParkingLot parkingLot2 = null;
    private ParkingLot parkingLot3 = null;
    private ParkingLot parkingLot4 = null;
    private ParkingLot parkingLot5 = null;
    private ParkingLot parkingLot6 = null;
    private ParkingLot parkingLot7 = null;
    private ParkingLot parkingLot8 = null;
    private ParkingLot parkingLot9 = null;
    private ParkingLot parkingLot10 = null;
    private ParkingBoy parkingBoy = new ParkingBoy();



    @BeforeEach
    public void initParkingLot() {
        parkingLot1 = new ParkingLot();
        parkingLot2 = new ParkingLot();
        parkingLot3 = new ParkingLot();
        parkingLot4 = new ParkingLot();
        parkingLot5 = new ParkingLot();
        parkingLot6 = new ParkingLot();
        parkingLot7 = new ParkingLot();
        parkingLot8 = new ParkingLot();
        parkingLot9 = new ParkingLot();
        parkingLot10 = new ParkingLot();
    }

    @Test
    void should_return_ticket_when_parking_with_parking_boy_given_valid_car() {
        Car car = new Car();

        ParkingTicket parkingTicket = parkingBoy.parkingCar(car);

        assertNotNull(parkingTicket);
    }
}
