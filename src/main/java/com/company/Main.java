package com.company;

import com.company.controller.Controller;
import com.company.model.initializeData.Trains;
import com.company.view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        Controller controller = new Controller(view, Trains.PASSENGER_TRAIN.getTrain());
        //Controller controller = new Controller(view, Trains.CARGO_TRAIN.getTrain());
        //Controller controller = new Controller(view, Trains.MIX_WAGONS_TRAIN.getTrain());
        controller.process();
    }
}
