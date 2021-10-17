package com.example.AEPB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingLotTests {

    private ParkingLot parkingLot = null;

    @BeforeEach
    public void initParkingLot() {
        parkingLot = new ParkingLot();
    }

    @Test
    void should_return_ticket_when_parking_given_valid_car() {
        Car car = new Car();

        ParkingTicket parkingTicket = parkingLot.parking(car);

        assertNotNull(parkingTicket);
    }

    @Test
    void should_decrease_position_when_parking_given_valid_car_and_parking_lot_with_enough_position() {
        Car car = new Car();
        int position = parkingLot.getAvailablePostion();

        ParkingTicket parkingTicket = parkingLot.parking(car);

        assertEquals(position - 1, parkingLot.getAvailablePostion());
    }

    @Test
    void should_failed_to_parking_when_parking_given_nothing() {

    }

    @Test
    void should_failed_to_parking_when_parking_given_car_has_already_parked() {

    }

    @Test
    void should_failed_to_parking_when_parking_given_parking_lot_with_not_enough_position() {

    }

    @Test
    void should_return_car_when_pick_up_car_given_valid_parking_ticket() {
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.parking(car);

        Car getCar = parkingLot.pickUp(parkingTicket);

        assertSame(car, getCar);

    }

    @Test
    void should_return_related_car_when_pick_up_car_given_valid_related_parking_ticket() {
        Car carA = new Car();
        Car carB = new Car();
        ParkingTicket parkingTicketA = parkingLot.parking(carA);
        ParkingTicket parkingTicketB = parkingLot.parking(carB);

        Car getCarA = parkingLot.pickUp(parkingTicketA);
        Car getCarB = parkingLot.pickUp(parkingTicketB);

        assertSame(carA, getCarA);
        assertSame(carB, getCarB);

    }

    @Test
    void should_increase_position_when_pick_up_car_given_valid_parking_ticket() {
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.parking(car);
        int position = parkingLot.getAvailablePostion();

        Car getCar = parkingLot.pickUp(parkingTicket);

        assertEquals(position + 1, parkingLot.getAvailablePostion());

    }

    @Test
    void should_failed_to_pick_up_when_pick_up_car_given_invalid_parking_ticket() {

    }

    @Test
    void should_failed_to_pick_up_when_pick_up_car_given_parking_ticket_has_used_twice() {

    }

    @Test
    void should_failed_to_pick_up_when_pick_up_car_given_parking_ticket_has_no_related_car() {

    }


}
