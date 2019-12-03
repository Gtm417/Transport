package com.company.model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class FreightWagonTest {
    private FreightWagon freightWagon = new FreightWagon("name",312,8,54);


    @Test
    public void testCompareToFreightWagonToPassenger() {
        int result = freightWagon.compareTo(new PassengerWagon("name2", 312,ComfortLevel.NORMAL));
        assertEquals(1, result);
    }

    @Test
    public void testCompareToFreightWagonsByMaxCarryingCapacityBiggerToLow(){
        int result = freightWagon.compareTo(new FreightWagon("name3", 3123,9,27));
        assertEquals(1,result);
    }

    @Test
    public void testCompareToFreightWagonsByMaxCarryingCapacityLesserToBigger(){
        int result =(new FreightWagon("name3", 3123,9,27)).compareTo(freightWagon);
        assertEquals(-1,result);
    }

    @Test
    public void testCompareToEqualsFreightWagonsByRef(){
        FreightWagon newWagon = freightWagon;
        int result = freightWagon.compareTo(newWagon);
        assertEquals(0, result);
    }

    @Test
    public void testCompareToEqualsFreightWagonsByMaxCarryingCapacity(){
        FreightWagon newWagon = new FreightWagon("name44", 312, 3,54);
        int result = freightWagon.compareTo(newWagon);
        assertEquals(0, result);
    }

}