package com.company.model.entity;

import java.util.ArrayList;

public class PassengerWagon extends Wagon {
    private int maxValueOfPassengers;
    private ArrayList<Passenger> passengers;
    private ComfortLevel comfortLevel;


    public PassengerWagon(String name, int number, ComfortLevel comfortLevel) {
        super(name, number);
        this.comfortLevel = comfortLevel;
    }

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
        double resultWeight = 0.0;
        for(Passenger passenger : passengers) {
            resultWeight += passenger.getBaggageWeight();
        }
        return resultWeight;
    }


    @Override
    // Пассажирский вагон всегда меньше чем грузовой
    public int compareTo(Wagon wagon) {
        if(wagon instanceof FreightWagon){
            return -1;
        }
        return compare(wagon);
    }

    private int compare(Wagon wagon) {
        PassengerWagon passengerWagon = (PassengerWagon) wagon;
        if(this == passengerWagon || this.comfortLevel.ordinal() == passengerWagon.comfortLevel.ordinal()) {
            return 0;
        }
        if(this.comfortLevel.ordinal() > passengerWagon.comfortLevel.ordinal()){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "PassengerWagon{" +
                "name= " + super.getName() +
                "maxValueOfPassengers= " + maxValueOfPassengers +
                ", passengers amount= " + passengers.size() +
                ", passengers baggage weight= " + getBaggageWeight() +
                ", comfortLevel= " + comfortLevel +
                '}';
    }

    private void addPassenger(Passenger passenger){
        if(maxValueOfPassengers > passengers.size()){
            passengers.add(passenger);
        }
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

