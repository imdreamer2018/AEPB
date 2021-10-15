package com.example.AEPB;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

class AirCoinTests {


    @Test
    void should_return_true_when_compare_given_two_same_aircoin_with_amount_of_1() {
        AirCoin airCoin1 = new AirCoin(1);
        AirCoin airCoin2 = new AirCoin(1);

        boolean result = airCoin1.compare(airCoin2);

        assertTrue(result);
    }

    @Test
    void should_return_false_when_compare_give_two_different_aircoin_with_amount_of_1_and_amount_of_2() {
        AirCoin airCoin1 = new AirCoin(1);
        AirCoin airCoin2 = new AirCoin(2);

        boolean result = airCoin1.compare(airCoin2);

        assertFalse(result);
    }

    @Test
    void should_return_false_when_compare_give_two_different_aircoin_with_amount_of_0_and_amount_of_1() {
        AirCoin airCoin1 = new AirCoin(0);
        AirCoin airCoin2 = new AirCoin(1);

        boolean result = airCoin1.compare(airCoin2);

        assertFalse(result);
    }

    @Test
    void should_return_false_when_compare_give_two_different_aircoin_with_amount_of_100_million_and_amount_of_1() {
        AirCoin airCoin1 = new AirCoin(1000000000);
        AirCoin airCoin2 = new AirCoin(1);

        boolean result = airCoin1.compare(airCoin2);

        assertFalse(result);
    }

    @Test
    void should_throw_exception_when_compare_given_aircoin_and_null() {
        AirCoin airCoin1 = new AirCoin(1);
        AirCoin airCoin2 = null;

        assertThrows(NullPointerException.class, () -> airCoin1.compare(airCoin2));
    }

    @Test
    void should_throw_exception_when_compare_given_aircoin_amount_less_than_0() {
        AirCoin airCoin1 = new AirCoin(-1);
        AirCoin airCoin2 = new AirCoin(1);

        assertThrows(IllegalArgumentException.class, () -> airCoin1.compare(airCoin2));
    }

    @Test
    void should_throw_exception_when_compare_given_aircoin_amount_more_than_100_million() {
        AirCoin airCoin1 = new AirCoin(1);
        AirCoin airCoin2 = new AirCoin(1000000001);

        assertThrows(IllegalArgumentException.class, () -> airCoin1.compare(airCoin2));
    }

}
