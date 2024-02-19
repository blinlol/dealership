package com.dealership.models;


public class Specification{
    private int hp;
    private int mileage;
    private String color;

    public Specification(){}

    public Specification(int hp, int mileage, String color) {
        this.hp = hp;
        this.mileage = mileage;
        this.color = color;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specification that = (Specification) o;
        if (hp != that.hp) return false;
        if (mileage != that.mileage) return false;
        if (!color.equals(that.color)) return false;
        return true;
    }
}