package com.company.model.entity;

public class FreightWagon extends TrainUnit {
    private int carryingCapacity; // in tons

    public FreightWagon(String name, int number, int carryingCapacity) {
        super(name, number);
        this.carryingCapacity = carryingCapacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}
