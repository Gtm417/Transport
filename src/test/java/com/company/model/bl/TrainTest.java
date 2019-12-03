package com.company.model.bl;

import com.company.model.entity.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class TrainTest {

    private Train train;


    private void initializePassengerTrain(){
        train = new Train(generatePassengerWagons(generateListOfPassengers()),new Locomotive(12,23));
    }

    private ArrayList<Passenger> generateListOfPassengers() {
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("name", 10.0));
        passengers.add(new Passenger("name1", 11.0));
        passengers.add(new Passenger("name2", 12.5));
        return passengers;
    }

    private ArrayList<Wagon> generatePassengerWagons(ArrayList<Passenger> passengers) {
        ArrayList<Wagon> wagons = new ArrayList<>();
        Wagon wagon1 = new PassengerWagon("name",312,5, ComfortLevel.NORMAL,passengers);
        Wagon wagon2 = new PassengerWagon("name",312,5, ComfortLevel.HIGH,passengers);
        Wagon wagon3 = new PassengerWagon("name",312,5, ComfortLevel.WEAK,passengers);
        Wagon wagon4= new PassengerWagon("name",312,5, ComfortLevel.WEAK,passengers);
        wagons.add(wagon1);
        wagons.add(wagon2);
        wagons.add(wagon3);
        wagons.add(wagon4);
        return wagons;
    }

    private void initializeCargoTrain() {
        train = new Train(generateFreightWagons(), new Locomotive(31,32));
    }

    private ArrayList<Wagon> generateFreightWagons() {
        ArrayList<Wagon> wagons = new ArrayList<>();
        wagons.add( new FreightWagon("name",312,5,32));
        wagons.add( new FreightWagon("name",312,5,54));
        wagons.add( new FreightWagon("name",312,5,35));
        wagons.add( new FreightWagon("name",312,5,44));
        return wagons;
    }

    private void initializeMixWagonTrain(){
        ArrayList<Wagon> wagons = new ArrayList<>(generateFreightWagons());
        wagons.addAll(generatePassengerWagons(generateListOfPassengers()));
        train = new Train(wagons, new Locomotive(12,32));
    }

    private boolean isSorted(ArrayList<Wagon> wagons){
        for(int i = 0; i < wagons.size() - 1; i++){
            if(wagons.get(i).compareTo(wagons.get(i + 1)) > 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void getSortedPassengerWagonsByComfortLevel(){
        initializePassengerTrain();
        train.getSortedWagons();
        assertTrue(train.wagonsToString(), isSorted(train.getWagons()));
    }

    @Test
    public void getSortedFreightWagonsByMaxCarryingCapacity() {
        initializeCargoTrain();
        train.getSortedWagons();
        assertTrue(train.wagonsToString(), isSorted(train.getWagons()));

    }

    @Test
    public void getSortedMixWagons() {
        initializeMixWagonTrain();
        train.getSortedWagons();
        assertTrue(train.wagonsToString(),isSorted(train.getWagons()));
    }

    @Test
    public void getTotalNumberOfPassengers() {
     initializePassengerTrain();
     int totalNumberOfPassengers = train.getTotalNumberOfPassengers();
     assertEquals(12, totalNumberOfPassengers);
    }

    @Test
    public void getTotalBaggageWeight(){
        initializePassengerTrain();
        double valueOfTotalBaggage = train.getTotalBaggageWeight();
        assertEquals(134, valueOfTotalBaggage,0.0001);
    }

    @Test
    public void getTotalCarryingCapacityOfTrain() {
        initializeCargoTrain();
        int resultValue = train.getTotalCurrentCarryingCapacityOfTrain();
        assertEquals(20, resultValue);
    }

    @Test
    public void testGetWagonsInPassengerDiapason(){
        initializePassengerTrain();
        int minBarrier = 1;
        int maxBarrier = 3;
        ArrayList<Wagon> wagonsInDiapason = train.getWagonsInPassengerDiapason(minBarrier,maxBarrier);
        assertTrue(isEveryWagonInDiapason(wagonsInDiapason,minBarrier,maxBarrier));
    }

    private boolean isEveryWagonInDiapason(ArrayList<Wagon> wagons, int minBarrier, int maxBarrier) {
        for(Wagon wagon : wagons){
            PassengerWagon passengerWagon = (PassengerWagon) wagon;
            if(passengerWagon.getAmountOfPassengers() < minBarrier || passengerWagon.getAmountOfPassengers() > maxBarrier){
                return false;
            }
        }
        return true;
    }
}