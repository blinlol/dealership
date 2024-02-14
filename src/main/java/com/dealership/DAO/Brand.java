package com.dealership.DAO;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    public Brand(){};
    public Brand(String name){
        // this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }
}
