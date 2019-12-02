package com.company.model.entity;

public class Locomotive extends TrainUnit{
    private int speed;
    private int power;

    public Locomotive(String name, int number, int speed, int power) {
        super(name, number);
        this.speed = speed;
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
