package com.example.AEPB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        parkingBoy.managementParkingLot(List.of(
                parkingLot1, parkingLot2, parkingLot3,
                parkingLot4, parkingLot5 ,parkingLot6,
                parkingLot7, parkingLot8, parkingLot9,
                parkingLot10));
    }

    @Test
    void should_return_ticket_when_parking_with_parking_boy_given_valid_car() {
        Car car = new Car();

        ParkingTicket parkingTicket = parkingBoy.parkingCar(car);

        assertNotNull(parkingTicket);
    }

    @Test
    void should_to_be_in_order_when_parking_boy_parking_car_given_valid_car() {
        Car car = new Car();

        parkingBoy.parkingCar(car);

        assertEquals(49, parkingLot1.getAvailablePosition());
    }

    @Test
    void should_to_be_in_order_when_parking_boy_parking_car_given_valid_car_and_parkingLot1_have_no_position() {
        for (int i = 0; i < 50; i++) {
            parkingLot1.parking(new Car());
        }

        Car car = new Car();
        parkingBoy.parkingCar(car);

        assertEquals(49, parkingLot2.getAvailablePosition());
    }

    @Test
    void should_parking_failed_when_parking_boy_parking_car_given_valid_car_and_all_parkingLots_have_no_position() {
        for (int i = 0; i < 50; i++) {
            parkingLot1.parking(new Car());
            parkingLot2.parking(new Car());
            parkingLot3.parking(new Car());
            parkingLot4.parking(new Car());
            parkingLot5.parking(new Car());
            parkingLot6.parking(new Car());
            parkingLot7.parking(new Car());
            parkingLot8.parking(new Car());
            parkingLot9.parking(new Car());
            parkingLot10.parking(new Car());
        }

        Car car = new Car();

        IllegalAccessError illegalAccessError = assertThrows(IllegalAccessError.class, () -> parkingBoy.parkingCar(car));

        assertEquals("parkingLot is not enough", illegalAccessError.getMessage());
    }

    @Test
    void should_parking_failed_when_parking_boy_parking_car_given_invalid_car() {
        Car car = null;

        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> parkingBoy.parkingCar(car));

        assertEquals("you cannot give me a null car", nullPointerException.getMessage());
    }
}
