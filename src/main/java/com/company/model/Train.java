package com.company.model;

import com.company.model.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * describe train and has main functions described in task
 * Train may have passenger wagons and freight wagons together
 * @author Hodik Timofey
 *
 */

public class Train {
    private List<Wagon> wagons;
    private ITraction locomotive;


    public Train(ArrayList<Wagon> wagons, ITraction locomotive) {
        this.wagons = wagons;
        this.locomotive = locomotive;
    }

    /**
     * sorting train wagons using methods Wagon compareTo
     * Collection.sort using merge sort or binary sort
     */
    public void sortWagons(){
        wagons.sort(Wagon::compareTo);
    }

    /**
     * If train has only freight wagons method return 0;
     * @return sum of passenger amount in all wagons
     */
    public int getTotalNumberOfPassengers(){
        return  wagons.stream().
                filter(wagon -> wagon instanceof PassengerWagon).
                mapToInt(wagon -> ((PassengerWagon) wagon).getAmountOfPassengers()).
                sum();
    }

    /**
     * If train has only freight wagons method return 0.0;
     * @return sum of passenger baggage weight in all wagons
     */
    public int getTotalBaggageWeight(){
        return  wagons.stream().
                filter(wagon -> wagon instanceof PassengerWagon).
                mapToInt(wagon -> ((PassengerWagon) wagon).getBaggageWeight()).
                sum();
    }

    /**
     * If train has only passenger wagons method return 0;
     * @return sum of carrying capacity in all freight wagons
     */
    public int getTotalCurrentCarryingCapacityOfTrain(){
        return wagons.stream().filter(wagon -> wagon instanceof FreightWagon).
                mapToInt(wagon -> ((FreightWagon) wagon).getCurrentCarryingCapacity()).sum();
    }


    /**
     * range is considered inclusive
     * @param minPassengers minimum amount of passengers
     * @param maxPassengers maximum amount of passengers
     * @return ArrayList of Wagons that in range
     */
    public List<Wagon> getWagonsInPassengerDiapason(int minPassengers, int maxPassengers){
        return wagons.stream().
                filter(wagon -> wagon instanceof PassengerWagon).
                filter(wagon -> ((PassengerWagon) wagon).getAmountOfPassengers() <= maxPassengers
                        && ((PassengerWagon) wagon).getAmountOfPassengers() >= minPassengers).
                collect(Collectors.toList());

    }




    @Override
    public String toString() {
        return "Train has: "
                + wagons.size() + " wagons, "
                + getTotalNumberOfPassengers() + " passengers, "
                + getTotalBaggageWeight() + " baggage weight, "
                + getTotalCurrentCarryingCapacityOfTrain() + " carrying capacity freights wagons";
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(ArrayList<Wagon> wagons) {
        this.wagons = wagons;
    }

    public ITraction getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }


}
