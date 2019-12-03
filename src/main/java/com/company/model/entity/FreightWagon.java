package com.company.model.entity;

public class FreightWagon extends Wagon {
    private int currentCarryingCapacity; // in tons
    private int maxCarryingCapacity;

    public FreightWagon(String name, int number, int currentCarryingCapacity, int maxCarryingCapacity) {
        super(name, number);
        this.currentCarryingCapacity = currentCarryingCapacity;
        this.maxCarryingCapacity = maxCarryingCapacity;
    }

    @Override
    // Грузовой вагон всегда больше чеи пассажирский
    public int compareTo(Wagon wagon) {
        if(wagon instanceof PassengerWagon){
            return 1;
        }
        return compare(wagon);
    }

    private int compare(Wagon wagon) {
        FreightWagon freightWagon = (FreightWagon) wagon;
        if(this == freightWagon || this.maxCarryingCapacity == freightWagon.maxCarryingCapacity) {
            return 0;
        }
        if(this.maxCarryingCapacity > freightWagon.maxCarryingCapacity){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "FreightWagon{" +
                "name" + super.getName() +
                "currentCarryingCapacity=" + currentCarryingCapacity +
                ", maxCarryingCapacity=" + maxCarryingCapacity +
                '}';
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
