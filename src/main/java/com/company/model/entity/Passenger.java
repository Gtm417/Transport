package com.company.model.entity;

/**
 * Passenger wagon passenger
 * Describes passenger
 * @author Hodik Timofey
 * @see PassengerWagon
 */

public class Passenger {
    private String  name;
    private int baggageWeight;

    public Passenger(String name, int baggageWeight) {
        this.name = name;
        this.baggageWeight = baggageWeight;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name= '" + name + '\'' +
                '}';
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(int baggageWeight) {
        this.baggageWeight = baggageWeight;
    }
}
