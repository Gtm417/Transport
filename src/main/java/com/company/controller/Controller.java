package com.company.controller;

import com.company.model.bl.Train;
import com.company.view.ConsoleView;



import static com.company.view.ViewConstants.*;

public class Controller {

    private static  final int MIN_BARRIER_OF_AMOUNT_PASSENGERS = 1;
    private static  final int MAX_BARRIER_OF_AMOUNT_PASSENGERS = 3;

    private ConsoleView view;
    private Train train;

    public Controller(ConsoleView view, Train train) {
        this.view = view;
        this.train = train;
    }

    public void process(){
        view.printUniversalMessage(PRINT_TRAIN_DATA,train.toString());
        view.printUniversalMessage(PRINT_TRAIN_WAGONS, train.wagonsToString(train.getWagons()));
        train.sortWagons();
        view.printUniversalMessage(PRINT_SORTED_TRAIN_WAGONS,train.wagonsToString(train.getWagons()));
        view.printUniversalMessage(PRINT_TRAIN_WAGONS_IN_DIAPASON, train.wagonsToString(
                train.getWagonsInPassengerDiapason(MIN_BARRIER_OF_AMOUNT_PASSENGERS, MAX_BARRIER_OF_AMOUNT_PASSENGERS)));

    }
}
