package com.company.model.entity;

public class Passenger {
    private String  name;
    private double baggageWeight;

    public Passenger(String name, double baggageWeight) {
        this.name = name;
        this.baggageWeight = baggageWeight;
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

    public void setBaggageWeight(double baggageWeight) {
        this.baggageWeight = baggageWeight;
    }
}