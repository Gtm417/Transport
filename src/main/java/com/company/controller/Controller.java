package com.company.controller;

import com.company.model.bl.Train;
import com.company.view.ConsoleView;

public class Controller {

    private ConsoleView view;
    private Train train;

    public Controller(ConsoleView view, Train train) {
        this.view = view;
        this.train = train;
    }

    public void process(){

    }
}
