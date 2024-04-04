package com.dealership.models;

import jakarta.persistence.*;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "configuration")
public class Configuration{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id")
    private Model model;

    private String name;

    private boolean is_new;

    private int count;

    private int price;

    @JdbcTypeCode(SqlTypes.JSON)
    private Specification specification;

    public Configuration(){}

    public Configuration(Model m,
                         String name,
                         boolean is_new,
                         int count,
                         int price,
                         Specification specification) {
        this.model = m;
        this.name = name;
        this.is_new = is_new;
        this.count = count;
        this.price = price;
        this.specification = specification;
    }

    public int getId() {
        return id;
    }

    public Brand getBrand(){
        return getModel().getBrand();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNew() {
        return is_new;
    }

    public void setNew(boolean aNew) {
        is_new = aNew;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return id == that.id &&
               model.equals(that.model) &&
               name.equals(that.name) &&
               is_new == that.is_new &&
               count == that.count &&
               price == that.price &&
               specification.equals(that.specification);
    }
}
