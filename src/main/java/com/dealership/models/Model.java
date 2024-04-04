package com.dealership.models;

import java.util.List;

import org.springframework.boot.context.config.ConfigDataResource;

import jakarta.persistence.*;

@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "model", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Configuration> configurations;

    public Model(){}

    public Model(String name, Brand brand){
        this.name = name;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Configuration> getConfigurations(){
        // if (onlyAvailable){
        //     return configurations.stream().filter(c -> c.getCount() > 0).toList();
        // }
        return configurations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id == model.id && 
               name.equals(model.name) &&
               brand.equals(model.brand);
    }
}
