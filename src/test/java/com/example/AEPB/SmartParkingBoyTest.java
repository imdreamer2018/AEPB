package com.example.AEPB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmartParkingBoyTest {

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
    private final ParkingBoy parkingBoy = new ParkingBoy();
    private final SmartParkingBoy smartParkingBoy = new SmartParkingBoy();



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
        smartParkingBoy.managementParkingLot(List.of(
                parkingLot1, parkingLot2, parkingLot3,
                parkingLot4, parkingLot5 ,parkingLot6,
                parkingLot7, parkingLot8, parkingLot9,
                parkingLot10));
    }

    //given 一台车
    //when 聪明男孩停车
    //then 返回一个车票
    @Test
    void should_return_ticket_when_parking_by_smart_parking_boy_given_valid_car() {
        Car car = new Car();

        ParkingTicket parkingTicket = smartParkingBoy.parkingCar(car);

        assertNotNull(parkingTicket);
    }

    @Test
    void should_parking_in_parking_lot_with_largest_remaining_position_when_smart_parking_boy_parking_car_given_valid_car() {
        LotsOfParing(parkingLot1, 49);
        LotsOfParing(parkingLot2, 48);
        LotsOfParing(parkingLot3, 47);
        LotsOfParing(parkingLot4, 46);
        LotsOfParing(parkingLot5, 45);
        LotsOfParing(parkingLot6, 44);
        LotsOfParing(parkingLot7, 43);
        LotsOfParing(parkingLot8, 42);
        LotsOfParing(parkingLot9, 41);
        LotsOfParing(parkingLot10, 40);
        Car car = new Car();

        smartParkingBoy.parkingCar(car);

        assertEquals(9, parkingLot10.getAvailablePosition());
    }

    @Test
    void should_parking_in_order_when_smart_parking_boy_parking_car_given_valid_car_and_the_same_remaining_position_of_parking_lot() {
        LotsOfParing(parkingLot1, 49);
        LotsOfParing(parkingLot2, 48);
        LotsOfParing(parkingLot3, 47);
        LotsOfParing(parkingLot4, 46);
        LotsOfParing(parkingLot5, 45);
        LotsOfParing(parkingLot6, 40);
        LotsOfParing(parkingLot7, 40);
        LotsOfParing(parkingLot8, 40);
        LotsOfParing(parkingLot9, 40);
        LotsOfParing(parkingLot10, 40);
        Car car = new Car();

        smartParkingBoy.parkingCar(car);

        assertEquals(9, parkingLot6.getAvailablePosition());
    }

    //given 一台无效车
    //when 聪明男孩停车
    //then 提示异常
    @Test
    void should_parking_falied_when_smart_parking_boy_parking_car_given_invalid_car() {
        Car car = null;

        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> smartParkingBoy.parkingCar(car));

        assertEquals("you can not give me a null car", nullPointerException.getMessage());
    }

    //given 一个有效车票
    //when 聪明男孩取车
    //then 返回一台车
    @Test
    void should_return_car_when_pick_up_by_smart_parking_boy_given_valid_parking_ticket_parking_by_smart_parking_boy() {
        Car car = new Car();

        ParkingTicket parkingTicket = smartParkingBoy.parkingCar(car);
        Car fetchCar = smartParkingBoy.pickUpCar(parkingTicket);

        assertSame(car, fetchCar);
    }

    @Test
    void should_return_car_when_pick_up_by_smart_parking_boy_given_valid_parking_ticket_parking_by_self() {
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot1.parking(car);

        Car fetchCar = smartParkingBoy.pickUpCar(parkingTicket);

        assertSame(car, fetchCar);
    }

    @Test
    void should_return_car_when_pick_up_by_smart_parking_boy_given_valid_parking_ticket_parking_by_parking_boy() {
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.parkingCar(car);

        Car fetchCar = smartParkingBoy.pickUpCar(parkingTicket);

        assertSame(car, fetchCar);
    }

    //given 一个无效票
    //when 聪明男孩取车
    //then 提示异常
    @Test
    void should_pick_up_failed_when_pick_up_by_parking_boy_given_invalid_parking_ticket() {
        ParkingTicket parkingTicket = null;
        ParkingTicket parkingTicket1 = new ParkingTicket();

        IllegalAccessError illegalAccessError = assertThrows(IllegalAccessError.class, () -> smartParkingBoy.pickUpCar(parkingTicket));
        IllegalAccessError illegalAccessError1 = assertThrows(IllegalAccessError.class, () -> smartParkingBoy.pickUpCar(parkingTicket1));

        assertEquals("this parking ticket is invalid", illegalAccessError.getMessage());
        assertEquals("this parking ticket is invalid", illegalAccessError1.getMessage());
    }

    private void LotsOfParing(ParkingLot parkingLot, int numbers) {
        for (int i = 0; i < numbers; i++) {
            Car car = new Car();
            parkingLot.parking(car);
        }
    }

}
