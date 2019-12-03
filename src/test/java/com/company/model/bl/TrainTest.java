package com.company.model.bl;

import com.company.model.entity.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class TrainTest {

    private Train train;
    private void initializePassengerTrain(){
     ArrayList<Passenger> passengers = new ArrayList<>();
     passengers.add(new Passenger("name", 10.0));
     passengers.add(new Passenger("name1", 11.0));
     passengers.add(new Passenger("name2", 12.5));
     ArrayList<Wagon> wagons = new ArrayList<>();
     Wagon wagon1 = new PassengerWagon("name",312,5, ComfortLevel.NORMAL,passengers);
     Wagon wagon2 = new PassengerWagon("name",312,5, ComfortLevel.HIGH,passengers);
     Wagon wagon3 = new PassengerWagon("name",312,5, ComfortLevel.WEAK,passengers);
     wagons.add(wagon1);
     wagons.add(wagon2);
     wagons.add(wagon3);
     train = new Train(wagons,new Locomotive(12,23));
    }

    private void initializeCargoTrain(){
        ArrayList<Wagon> wagons = new ArrayList<>();
        wagons.add( new FreightWagon("name",312,5));
        wagons.add( new FreightWagon("name",312,5));
        wagons.add( new FreightWagon("name",312,5));
        train = new Train(wagons, new Locomotive(31,32));
    }

    @Test
    public void getSortedPassengerWagonsByComfortLevel() {

    }

    @Test
    public void getTotalNumberOfPassengers() {
     initializePassengerTrain();
     int totalNumberOfPassengers = train.getTotalNumberOfPassengers();
     assertEquals(9, totalNumberOfPassengers);
    }

    @Test
    public void getTotalBaggageWeight(){
        initializePassengerTrain();
        double valueOfTotalBaggage = train.getTotalBaggageWeight();
        assertEquals(100.5, valueOfTotalBaggage,0.0001);
    }

    @Test
    public void getTotalCarryingCapacityOfTrain() {
        initializeCargoTrain();
    }
}