package com.example.AEPB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingRobotTests {


    private ParkingLot parkingLot1 = null;
    private ParkingLot parkingLot2 = null;
    private ParkingLot parkingLot3 = null;
    private ParkingLot parkingLot4 = null;
    private ParkingLot parkingLot5 = null;
    private ParkingLot parkingLot6 = null;
    private ParkingLot parkingLot7 = null;

    ParkingRobot parkingRobot = new ParkingRobot();
    private final ParkingBoy parkingBoy = new ParkingBoy();
    private final SmartParkingBoy smartParkingBoy = new SmartParkingBoy();

    @BeforeEach
    public void initParkingLot() {
        parkingLot1 = new ParkingLot(1, 10);
        parkingLot2 = new ParkingLot(2, 15);
        parkingLot3 = new ParkingLot(3, 20);
        parkingLot4 = new ParkingLot(4, 25);
        parkingLot5 = new ParkingLot(5, 30);
        parkingLot6 = new ParkingLot(6, 35);
        parkingLot7 = new ParkingLot(7, 40);
        parkingRobot.managementParkingLot(List.of(
                parkingLot1, parkingLot2, parkingLot3,
                parkingLot4, parkingLot5 ,parkingLot6,
                parkingLot7
                ));

        parkingBoy.managementParkingLot(List.of(
                parkingLot1, parkingLot2, parkingLot3,
                parkingLot4, parkingLot5 ,parkingLot6,
                parkingLot7));
        smartParkingBoy.managementParkingLot(List.of(
                parkingLot1, parkingLot2, parkingLot3,
                parkingLot4, parkingLot5 ,parkingLot6,
                parkingLot7));
    }


    @Test
    void should_return_ticket_when_robot_parking_given_a_valid_car() {
        Car car = new Car();

        ParkingTicket parkingTicket = parkingRobot.parking(car);

        assertNotNull(parkingTicket);
    }

    @Test
    void should_throw_exception_when_robot_parking_given_a_invalid_car() {
        Car car = null;

        assertThrows(NullPointerException.class, () -> parkingRobot.parking(car));
    }

    @Test
    void should_parking_the_highest_vacancy_rate_parking_lot_when_robot_parking_given_a_valid_car() {
        Car car = new Car();
        lotsOfParing(parkingLot1, 2);
        lotsOfParing(parkingLot2, 2);
        lotsOfParing(parkingLot3, 2);
        lotsOfParing(parkingLot4, 2);
        lotsOfParing(parkingLot5, 2);
        lotsOfParing(parkingLot6, 2);
        lotsOfParing(parkingLot7, 2);

        parkingRobot.parking(car);

        assertEquals(37, parkingLot7.getAvailablePosition());

    }

    @Test
    void should_parking_by_order_when_robot_parking_given_the_same_vacancy_rate_parking_lot_list() {
        Car car = new Car();

        parkingRobot.parking(car);

        assertEquals(9, parkingLot1.getAvailablePosition());
    }

    @Test
    void should_return_car_when_parking_lot_pick_up_given_a_valid_ticket() {
        Car car = new Car();

        ParkingTicket ticket = parkingRobot.parking(car);

        Car pickUpCar = parkingLot1.pickUp(ticket);

        assertSame(car, pickUpCar);
    }

    @Test
    void should_return_car_when_parking_boy_pick_up_given_a_valid_ticket() {
        Car car = new Car();

        ParkingTicket ticket = parkingRobot.parking(car);

        Car pickUpCar = parkingBoy.pickUpCar(ticket);

        assertSame(car, pickUpCar);
    }

    @Test
    void should_return_car_when_smart_parking_boy_pick_up_given_a_valid_ticket() {
        Car car = new Car();

        ParkingTicket ticket = parkingRobot.parking(car);

        Car pickUpCar = smartParkingBoy.pickUpCar(ticket);

        assertSame(car, pickUpCar);
    }


    private void lotsOfParing(ParkingLot parkingLot, int numbers) {
        for (int i = 0; i < numbers; i++) {
            Car car = new Car();
            parkingLot.parking(car);
        }
    }
}
