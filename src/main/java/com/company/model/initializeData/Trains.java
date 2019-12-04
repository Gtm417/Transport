package com.company.model.initializeData;

import com.company.model.bl.Train;
import com.company.model.entity.*;

import java.util.ArrayList;

public enum Trains {

    PASSENGER_TRAIN(GenerateTrain.initializePassengerTrain()),
    CARGO_TRAIN(GenerateTrain.initializeCargoTrain()),
    MIX_WAGONS_TRAIN(GenerateTrain.initializeMixWagonTrain());

    Train train;

    private Trains (Train train){
        this.train = train;
    }

    public Train getTrain() {
        return train;
    }
}
