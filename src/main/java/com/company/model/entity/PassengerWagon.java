package com.company.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes passenger wagons
 * @author Hodik Timofey
 *
 */

public class PassengerWagon extends Wagon {
    private int maxValueOfPassengers;
    private List<Passenger> passengers;
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



    /**
     * get baggage weight every passenger and sum
     * @return resultWeight sum baggage weight
     * @return 0.0 if wagon hasn't passengers
     */
    public int getBaggageWeight(){
        int resultWeight = 0; //лонг
        for(Passenger passenger : passengers) {
            resultWeight += passenger.getBaggageWeight();
        }
        return resultWeight;
    }

    /**
     * compare this wagon with another
     * Freight wagon always bigger than  passenger
     * @param wagon with which compare
     * @return 0 if wagons equals
     * @return -1 if this wagon less than with which compare
     * @return 1 if this wagon bigger than with which compare
     * @return -1 if wagon with which compare is freight wagon
     */
    @Override
    public int compareTo(Wagon wagon) {
        if(wagon instanceof FreightWagon){
            return -1;
        }
        PassengerWagon passengerWagon = (PassengerWagon) wagon;
        return this.comfortLevel.ordinal() - passengerWagon.comfortLevel.ordinal();
    }



    @Override
    public String toString() {
        return "PassengerWagon{" +
                "name= " + super.getName() +
                "maxValueOfPassengers= " + maxValueOfPassengers +
                ", passengers amount= " + passengers.size() +
                ", passengers baggage weight= " + getBaggageWeight() +
                ", comfortLevel= " + comfortLevel +
                '}' + "\n";
    }


    public int getAmountOfPassengers() {
        return passengers.size();
    }

    public int getMaxValueOfPassengers(){
        return maxValueOfPassengers;
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

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
}

