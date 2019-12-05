package com.company.model.entity;

/**
 * Moving part of train
 * Describes locomotive
 * @author Hodik Timofey
 * @see com.company.model.Train
 */
public class Locomotive {

    private int speed;
    private int power;

    public Locomotive(int speed, int power) {
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
