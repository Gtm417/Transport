package com.company.model.initializeData;

import com.company.model.bl.Train;
import com.company.model.entity.*;

import java.util.ArrayList;

public class GenerateTrain {


    public static Train initializePassengerTrain(){
        return new Train(GenerateTrain.generatePassengerWagons(),new Locomotive(12,23));
    }

    public static Train initializeMixWagonTrain(){
        ArrayList<Wagon> wagons = new ArrayList<>(GenerateTrain.generateFreightWagons());
        wagons.addAll(GenerateTrain.generatePassengerWagons());
        return new Train(wagons, new Locomotive(12,32));
    }

    public static Train initializeCargoTrain() {
        return new Train(GenerateTrain.generateFreightWagons(), new Locomotive(31,32));
    }


   private static ArrayList<Wagon> generateFreightWagons() {
        ArrayList<Wagon> wagons = new ArrayList<>();
        wagons.add( new FreightWagon("name1",311,3,32));
        wagons.add( new FreightWagon("name2",312,9,54));
        wagons.add( new FreightWagon("name3",313,3,35));
        wagons.add( new FreightWagon("name4",314,1,44));
        return wagons;
    }

    private static ArrayList<Passenger> generateListOfPassengers(int numberOfPassenger) {
        ArrayList<Passenger> passengers = new ArrayList<>();
        for(int i = 1; i <= numberOfPassenger; i++){
            passengers.add(new Passenger("name" + i, 10.0));
        }
        return passengers;
    }

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
