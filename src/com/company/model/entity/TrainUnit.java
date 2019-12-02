package com.company.model.entity;

public abstract class TrainUnit {
    private String name;
    private int number;

    public TrainUnit(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public int hashCode() {
        return (number * 56 + ((name == null) ? 0 : name.hashCode()));
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj instanceof TrainUnit){
            TrainUnit trainUnit = (TrainUnit)obj;
            return trainUnit.number == number && name.equals(trainUnit.name);
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
