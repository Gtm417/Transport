package com.company.model.entity;

import java.util.ArrayList;

public class PassengerWagon extends Wagon {
    private int maxValueOfPassengers;
    private ArrayList<Passenger> passengers;
    private ComfortLevel comfortLevel;


    public PassengerWagon(String name, int number, int maxValueOfPassengers, ComfortLevel comfortLevel, ArrayList<Passenger> passengers) {
        super(name, number);
        this.maxValueOfPassengers = maxValueOfPassengers;
        this.comfortLevel = comfortLevel;
        this.passengers = passengers;
    }

    public int getMaxValueOfPassengers(){
        return maxValueOfPassengers;
    }

    public double getBaggageWeight(){
        int resultWeight = 0;
        for(Passenger passenger : passengers) {
            resultWeight += passenger.getBaggageWeight();
        }
        return resultWeight;
    }

    @Override
    public int compareTo(Wagon wagon) {
        if(wagon instanceof FreightWagon){
            return 1;
        }
        return compare(wagon);
    }

    private int compare(Wagon wagon) {
        PassengerWagon passengerWagon = (PassengerWagon) wagon;
        if(this == passengerWagon) {
            return 0;
        }
        if(this.comfortLevel.ordinal() > passengerWagon.comfortLevel.ordinal()){
            return 1;
        }
        return -1;
    }

    public int getAmountOfPassengers() {
        return passengers.size();
    }

    public void setMaxValueOfPassengers(int maxValueOfPassengers) {
        this.maxValueOfPassengers = maxValueOfPassengers;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(ComfortLevel comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
}

