package com.company.model.entity;

public abstract class Wagon implements Comparable<Wagon>  {
    private String name;
    private int number;

    public Wagon(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public abstract int compareTo(Wagon wagon);

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
        if(obj instanceof Wagon){
            Wagon wagon = (Wagon)obj;
            return wagon.number == number && name.equals(wagon.name);
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
