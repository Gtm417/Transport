package com.company.model.initializeData;

import com.company.model.Train;

/**
 * Started data for work program
 * Using GenerateTrain
 * Enum has  3 variants of trains:
 * 1) passenger train
 * 2) cargo train
 * 3) mix train
 * @author Hodik Timofey
 * @see Train
 * @see java.lang.Enum
 * @see GenerateTrain
 */

public enum Trains {

    PASSENGER_TRAIN(GenerateTrain.initializePassengerTrain()),
    CARGO_TRAIN(GenerateTrain.initializeCargoTrain()),
    MIX_WAGONS_TRAIN(GenerateTrain.initializeMixWagonTrain());

    Train train;

     Trains (Train train){
        this.train = train;
    }

    public Train getTrain() {
        return train;
    }
}
