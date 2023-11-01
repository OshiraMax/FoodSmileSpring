package com.foodsmile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rationId;
    private String name;

    public Integer getRationId() {
        return rationId;
    }

    public void setRationId(Integer rationId) {
        this.rationId = rationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
