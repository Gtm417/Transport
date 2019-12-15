package com.company.model.initializeData;

import com.company.model.Train;
import com.company.model.entity.*;

import java.util.ArrayList;

/**
 *First initializing Trains
 * Using in TrainTests
 * Using in Enum Trains
 * @author Hodik Timofey
 * @see Trains
 */

public class GenerateTrain {

    /**
     * Initialize passenger train
     * @return train only with passenger wagons
     */
    public static Train initializePassengerTrain(){
        return new Train(GenerateTrain.generatePassengerWagons(),new Locomotive(12,23));
    }

    /**
     * Initialize mix wagon  train
     * @return train with passenger and freight wagons
     */
    public static Train initializeMixWagonTrain(){
        ArrayList<Wagon> wagons = new ArrayList<>(GenerateTrain.generateFreightWagons());
        wagons.addAll(GenerateTrain.generatePassengerWagons());
        return new Train(wagons, new Locomotive(12,32));
    }
    /**
     * Initialize mix wagon  train
     * @return train only with freight wagons
     */
    public static Train initializeCargoTrain() {
        return new Train(GenerateTrain.generateFreightWagons(), new Locomotive(31,32));
    }

    /**
     * generate list of 4 Freight wagons
     * @return ArrayList of Freight Wagons
     */
   private static ArrayList<Wagon> generateFreightWagons() {
        ArrayList<Wagon> wagons = new ArrayList<>();
        wagons.add( new FreightWagon("name1",311,3,32));
        wagons.add( new FreightWagon("name2",312,9,54));
        wagons.add( new FreightWagon("name3",313,3,35));
        wagons.add( new FreightWagon("name4",314,1,44));
        return wagons;
    }

    /**
     * generate list of Passengers
     * @param numberOfPassenger describes amount of passengers in list
     * @return ArrayList of Passenger
     */
    private static ArrayList<Passenger> generateListOfPassengers(int numberOfPassenger) {
        ArrayList<Passenger> passengers = new ArrayList<>();
        for(int i = 1; i <= numberOfPassenger; i++){
            passengers.add(new Passenger("name" + i, 10));
        }
        return passengers;
    }

    /**
     * generate 4 Passenger wagons with 1,2,3,4 passengers
     *
     * @return ArrayList of Passenger wagons
     */
    private static ArrayList<Wagon> generatePassengerWagons() {
        ArrayList<Wagon> wagons = new ArrayList<>();
        Wagon wagon1 = new PassengerWagon("name1",312,34, ComfortLevel.NORMAL,generateListOfPassengers(2));
        Wagon wagon2 = new PassengerWagon("name2",313,12, ComfortLevel.HIGH,generateListOfPassengers(1));
        Wagon wagon3 = new PassengerWagon("name3",314,54, ComfortLevel.WEAK,generateListOfPassengers(3));
        Wagon wagon4= new PassengerWagon("name4",315,54, ComfortLevel.WEAK,generateListOfPassengers(4));
        wagons.add(wagon1);
        wagons.add(wagon2);
        wagons.add(wagon3);
        wagons.add(wagon4);
        return wagons;
    }


}
