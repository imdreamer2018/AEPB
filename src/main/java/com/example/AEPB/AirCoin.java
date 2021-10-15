package com.example.AEPB;


public class AirCoin {
    private long amount;

    public AirCoin(long amount) {
        this.amount = amount;
    }

    public boolean compare(AirCoin anotherAirCoin) {
        validateAircoinAmount(anotherAirCoin);
        return this.amount == anotherAirCoin.amount;
    }

    private void validateAircoinAmount(AirCoin anotherAirCoin) {
        if (anotherAirCoin.amount < 0 || this.amount < 0) {
            throw new IllegalArgumentException();
        }

        if (anotherAirCoin.amount > 1000000000 || this.amount > 1000000000) {
            throw new IllegalArgumentException();
        }
    }
}
