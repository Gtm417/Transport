package com.company.model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerWagonTest {

    private PassengerWagon passengerWagon = new PassengerWagon("name", 313, ComfortLevel.NORMAL);

    @Test
    public void testCompareToPassengerWagonsToFreight() {
        int result = passengerWagon.compareTo(new FreightWagon("name", 31, 5,32));
        assertEquals(-1, result);
    }

}