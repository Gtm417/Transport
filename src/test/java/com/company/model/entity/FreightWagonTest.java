package com.company.model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class FreightWagonTest {
    FreightWagon freightWagon = new FreightWagon("name",312,8,54);
    @Test
    public void testCompareToPassengerWagonToFreight() {
        int result = (new PassengerWagon("name2", 312,ComfortLevel.NORMAL).compareTo(freightWagon));
        assertEquals(-1, result);
    }

    @Test
    public void testCompareToFreightWagonToPassenger() {
        int result = freightWagon.compareTo(new PassengerWagon("name2", 312,ComfortLevel.NORMAL));
        assertEquals(1, result);
    }
}