package com.company.model.entity;

public class FreightWagon extends Wagon {
    private int carryingCapacity; // in tons

    public FreightWagon(String name, int number, int carryingCapacity) {
        super(name, number);
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public int compareTo(Wagon wagon) {
        if(wagon instanceof PassengerWagon){
            return -1;
        }
        return compare(wagon);
    }

    private int compare(Wagon wagon) {
        return 0;
    }


    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}
