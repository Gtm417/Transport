package com.company.model.bl;

import com.company.model.entity.ComfortLevel;
import com.company.model.entity.Passenger;
import com.company.model.entity.PassengerWagon;
import com.company.model.entity.TrainUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Train {
    ArrayList<TrainUnit> trainUnits;
    ArrayList<PassengerWagon> test;


    public Train(ArrayList<TrainUnit> trainUnits) {
        this.trainUnits = trainUnits;
    }

    public void getSortedPassengerWagonsByComfortLevel(){
        trainUnits.sort();
    }

    public int getTotalNumberOfPassengers(){
        int passengerRes = 0;
        for(TrainUnit trainUnit : trainUnits){
            if(trainUnit instanceof PassengerWagon){
                passengerRes += ((PassengerWagon) trainUnit).getAmountOfPassengers();
            }
        }
        return passengerRes;
    }

    public double getTotalBaggageWeight(){
        int baggageRes = 0;
        for(TrainUnit trainUnit : trainUnits){
            if(trainUnit instanceof PassengerWagon){
                baggageRes += ((PassengerWagon) trainUnit).getBaggageWeight();
            }
        }
        return baggageRes;
    }

    public ArrayList<TrainUnit> getTrainUnits() {
        return trainUnits;
    }

    public void setTrainUnits(ArrayList<TrainUnit> trainUnits) {
        this.trainUnits = trainUnits;
    }
}
