package com.dealership.models;

import jakarta.persistence.Column;
// import jakarta.persistence.Column;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "brand", orphanRemoval = true)
    private List<Model> models;

    public Brand(){};

    public Brand(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
