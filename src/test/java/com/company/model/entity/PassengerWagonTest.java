package com.company.model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerWagonTest {

    private Wagon passengerWagon = new PassengerWagon("name", 313, ComfortLevel.NORMAL);

    @Test
    public void testCompareToPassengerWagonsToFreight() {
        int result = passengerWagon.compareTo(new FreightWagon("name", 31, 5,32));
        assertTrue( result < 0);
    }

    @Test
    public void testCompareToPassengerWagonsByComfortLevelBiggerToLow(){
        int result = passengerWagon.compareTo(new PassengerWagon("name3", 3123,ComfortLevel.WEAK));
        assertTrue( result > 0);
    }

    @Test
    public void testCompareToPassengerWagonsByComfortLevelLesserToBigger(){
        int result =(new PassengerWagon("name3", 3123,ComfortLevel.WEAK)).compareTo(passengerWagon);
        assertTrue( result < 0);
    }

    @Test
    public void testCompareToEqualsPassengerWagonsByRef(){
       Wagon newWagon = passengerWagon;
        int result = passengerWagon.compareTo(newWagon);
        assertEquals(0, result);
    }

    @Test
    public void testCompareToEqualsFreightWagonsByMaxCarryingCapacity(){
        PassengerWagon newWagon = new PassengerWagon("name44", 312, ComfortLevel.NORMAL);
        int result = passengerWagon.compareTo(newWagon);
        assertEquals(0, result);
    }

}