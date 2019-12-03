package com.company.model.entity;

public class FreightWagon extends Wagon {
    private int currentCarryingCapacity; // in tons
    private int maxCarryingCapacity;

    public FreightWagon(String name, int number, int currentCarryingCapacity) {
        super(name, number);
        this.currentCarryingCapacity = currentCarryingCapacity;
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

    public int getCurrentCarryingCapacity() {
        return currentCarryingCapacity;
    }

    public void setCurrentCarryingCapacity(int currentCarryingCapacity) {
        if(currentCarryingCapacity < maxCarryingCapacity){
            this.currentCarryingCapacity = currentCarryingCapacity;
        }
    }

    public int getMaxCarryingCapacity() {
        return maxCarryingCapacity;
    }

    public void setMaxCarryingCapacity(int maxCarryingCapacity) {
        this.maxCarryingCapacity = maxCarryingCapacity;
    }
}
