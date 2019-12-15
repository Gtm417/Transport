package com.company.model;

import com.company.model.entity.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * describe train and has main functions described in task
 * Train may have passenger wagons and freight wagons together
 * @author Hodik Timofey
 *
 */

public class Train {
    private ArrayList<Wagon> wagons;
    private Locomotive locomotive;


    public Train(ArrayList<Wagon> wagons, Locomotive locomotive) {
        this.wagons = wagons;
        this.locomotive = locomotive;
    }

    /**
     * sorting train wagons using methods Wagon compareTo
     * Collection.sort using merge sort or binary sort
     */
    public void sortWagons(){
        Collections.sort(wagons);
    }

    /**
     * If train has only freight wagons method return 0;
     * @return sum of passenger amount in all wagons
     */
    public int getTotalNumberOfPassengers(){
        int passengerRes = 0;
        for(Wagon wagon : wagons){
            if(wagon instanceof PassengerWagon){
                passengerRes += ((PassengerWagon) wagon).getAmountOfPassengers();
            }
        }
        return passengerRes;
    }

    /**
     * If train has only freight wagons method return 0.0;
     * @return sum of passenger baggage weight in all wagons
     */
    public double getTotalBaggageWeight(){
        double baggageRes = 0.0;
        for(Wagon wagon : wagons){
            if(wagon instanceof PassengerWagon){
                baggageRes += ((PassengerWagon) wagon).getBaggageWeight();
            }
        }
        return baggageRes;
    }

    /**
     * If train has only passenger wagons method return 0;
     * @return sum of carrying capacity in all freight wagons
     */
    public int getTotalCurrentCarryingCapacityOfTrain(){
        int totalCapacity = 0;
        for(Wagon wagon : wagons){
            if(wagon instanceof FreightWagon){
                totalCapacity += ((FreightWagon) wagon).getCurrentCarryingCapacity();
            }
        }
        return totalCapacity;
    }


    /**
     * range is considered inclusive
     * @param minPassengers minimum amount of passengers
     * @param maxPassengers maximum amount of passengers
     * @return ArrayList of Wagons that in range
     */
    public ArrayList<Wagon> getWagonsInPassengerDiapason(int minPassengers, int maxPassengers){
        ArrayList<Wagon> resultListOfWagons = new ArrayList<>();
        for(Wagon wagon : wagons){
            try{
                PassengerWagon passengerWagon = (PassengerWagon)wagon;
            }catch(ClassCastException ex){
                continue;
            }
            if(wagon instanceof PassengerWagon && isInDiapason((PassengerWagon)wagon, minPassengers,maxPassengers)){
                resultListOfWagons.add(wagon);
            }
        }
        return resultListOfWagons;
    }

    private boolean isInDiapason(PassengerWagon passengerWagon,int minPassengers, int maxPassengers){
        return passengerWagon.getAmountOfPassengers() <= maxPassengers && passengerWagon.getAmountOfPassengers() >= minPassengers;
    }

    @Override
    public String toString() {
        return "Train has: "
                + wagons.size() + " wagons, "
                + getTotalNumberOfPassengers() + " passengers, "
                + getTotalBaggageWeight() + " baggage weight, "
                + getTotalCurrentCarryingCapacityOfTrain() + " carrying capacity freights wagons";
    }

    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(ArrayList<Wagon> wagons) {
        this.wagons = wagons;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }


}
