package com.company.model.bl;

import com.company.model.entity.*;

import java.util.ArrayList;
import java.util.Collections;

public class Train {
    private ArrayList<Wagon> wagons;
    private Locomotive locomotive;


    public Train(ArrayList<Wagon> wagons, Locomotive locomotive) {
        this.wagons = wagons;
        this.locomotive = locomotive;
    }

    public void sortWagons(){
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

    public int getTotalCurrentCarryingCapacityOfTrain(){
        int totalCapacity = 0;
        for(Wagon wagon : wagons){
            if(wagon instanceof FreightWagon){
                totalCapacity += ((FreightWagon) wagon).getCurrentCarryingCapacity();
            }
        }
        return totalCapacity;
    }



    // Диапазон считается включительно
    public ArrayList<Wagon> getWagonsInPassengerDiapason(int minPassengers, int maxPassengers){
        ArrayList<Wagon> resultListOfWagons = new ArrayList<>();
        for(Wagon wagon : wagons){
            if(wagon instanceof PassengerWagon){
                PassengerWagon passengerWagon = (PassengerWagon) wagon;
                if(passengerWagon.getAmountOfPassengers() <= maxPassengers && passengerWagon.getAmountOfPassengers() >= minPassengers){
                    resultListOfWagons.add(wagon);
                }
            }
        }
        return resultListOfWagons;
    }

    //??
    public String wagonsToString(ArrayList<Wagon> wagons){
        StringBuilder stringBuilder = new StringBuilder();
        for(Wagon wagon : wagons){
            stringBuilder.append(wagon.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
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
