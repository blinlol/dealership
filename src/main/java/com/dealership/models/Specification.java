package com.dealership.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import java.util.*;
import java.io.Serializable;

@Embeddable
public class Specification implements Serializable{
    private int hp;
    private int mileage;
    private String color;

    public static List<String> getFields(){
        List<String> fields = new ArrayList<>();
        fields.add("hp");
        fields.add("mileage");
        fields.add("color");
        return fields;
    }

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