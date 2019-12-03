package com.company.model.bl;

import com.company.model.entity.FreightWagon;
import com.company.model.entity.Locomotive;
import com.company.model.entity.PassengerWagon;
import com.company.model.entity.Wagon;

import java.util.ArrayList;
import java.util.Collections;

public class Train {
    private ArrayList<Wagon> wagons;
    private Locomotive locomotive;


    public Train(ArrayList<Wagon> wagons, Locomotive locomotive) {
        this.wagons = wagons;
        this.locomotive = locomotive;
    }

    public void getSortedPassengerWagonsByComfortLevel(){
        Collections.sort(wagons);
    }

    public int getTotalNumberOfPassengers(){
        int passengerRes = 0;
        for(Wagon wagon : wagons){
            if(wagon instanceof PassengerWagon){
                passengerRes += ((PassengerWagon) wagon).getAmountOfPassengers();
            }
        }
        return passengerRes;
    }

    public double getTotalBaggageWeight(){
        double baggageRes = 0.0;
        for(Wagon wagon : wagons){
            if(wagon instanceof PassengerWagon){
                baggageRes += ((PassengerWagon) wagon).getBaggageWeight();
            }
        }
        return baggageRes;
    }

    public int getTotalCarryingCapacityOfTrain(){
        int totalCapacity = 0;
        for(Wagon wagon : wagons){
            if(wagon instanceof FreightWagon){
                totalCapacity += ((FreightWagon) wagon).getCarryingCapacity();
            }
        }
        return totalCapacity;
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
