package com.company.model.entity;

    /**
    * describes freight wagon
     * extends from abstract Wagon
     * @see Wagon
     * @author Hodik Timofey
     *
    */
public class FreightWagon extends Wagon {
        /** wagon current carrying capacity in tons*/
    private int currentCarryingCapacity;
        /** wagon maximum carrying capacity in tons*/
    private int maxCarryingCapacity;


    public FreightWagon(String name, int number, int currentCarryingCapacity, int maxCarryingCapacity) {
        super(name, number);
        this.currentCarryingCapacity = currentCarryingCapacity;
        this.maxCarryingCapacity = maxCarryingCapacity;
    }

        /**
         * compare this wagon with another
         * Freight wagon always bigger than  passenger
         * @param wagon with which compare
         * @return 0 if wagons equals
         * @return -1 if this wagon less than with which compare
         * @return 1 if this wagon bigger than with which compare
         * @return 1 if wagon with which compare is passenger wagon
         */
    @Override
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
                '}' + "\n";
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
