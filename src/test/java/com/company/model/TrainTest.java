package com.company.model;

import com.company.model.Train;
import com.company.model.entity.*;
import com.company.model.initializeData.GenerateTrain;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class TrainTest {

    private Train train;


    private boolean isSorted(List<Wagon> wagons){
        for(int i = 0; i < wagons.size() - 1; i++){
            if(wagons.get(i).compareTo(wagons.get(i + 1)) > 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void getSortedPassengerWagonsByComfortLevel(){
        train = GenerateTrain.initializePassengerTrain();
        train.sortWagons();
        assertTrue(train.getWagons().toString(), isSorted(train.getWagons()));
    }

    @Test
    public void getSortedFreightWagonsByMaxCarryingCapacity() {
        train = GenerateTrain.initializeCargoTrain();
        train.sortWagons();
        assertTrue(train.getWagons().toString(), isSorted(train.getWagons()));

    }

    @Test
    public void getSortedMixWagons() {
        train = GenerateTrain.initializeMixWagonTrain();
        train.sortWagons();
        assertTrue(train.getWagons().toString(),isSorted(train.getWagons()));
    }

    @Test
    public void getTotalNumberOfPassengers() {
        train = GenerateTrain.initializePassengerTrain();
        int totalNumberOfPassengers = train.getTotalNumberOfPassengers();
        assertEquals(10, totalNumberOfPassengers);
    }

    @Test
    public void getTotalBaggageWeight(){
        train = GenerateTrain.initializePassengerTrain();
        double valueOfTotalBaggage = train.getTotalBaggageWeight();
        assertEquals(100.0, valueOfTotalBaggage,0.0001);
    }

    @Test
    public void getTotalCarryingCapacityOfTrain() {
        train = GenerateTrain.initializeCargoTrain();
        int resultValue = train.getTotalCurrentCarryingCapacityOfTrain();
        assertEquals(16, resultValue);
    }

    @Test
    public void testGetWagonsInPassengerDiapason(){
        train = GenerateTrain.initializePassengerTrain();
        int minBarrier = 1;
        int maxBarrier = 3;
        List<Wagon> wagonsInDiapason = train.getWagonsInPassengerDiapason(minBarrier,maxBarrier);
        assertTrue(isEveryWagonInDiapason(wagonsInDiapason,minBarrier,maxBarrier));
    }

    private boolean isEveryWagonInDiapason(List<Wagon> wagons, int minBarrier, int maxBarrier) {
        for(Wagon wagon : wagons){
            PassengerWagon passengerWagon = (PassengerWagon) wagon;
            if(passengerWagon.getAmountOfPassengers() < minBarrier || passengerWagon.getAmountOfPassengers() > maxBarrier){
                return false;
            }
        }
        return true;
    }
}