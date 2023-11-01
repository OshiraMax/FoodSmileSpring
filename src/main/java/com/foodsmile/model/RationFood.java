package com.foodsmile.model;

import jakarta.persistence.*;

@Entity
public class RationFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rationFoodId;

    @ManyToOne
    @JoinColumn(name = "rationId", referencedColumnName = "rationId")
    private Ration ration;

    @ManyToOne
    @JoinColumn(name = "foodId", referencedColumnName = "foodId")
    private Product product;

    private Float quantity;

    public Integer getRationFoodId() {
        return rationFoodId;
    }

    public void setRationFoodId(Integer rationFoodId) {
        this.rationFoodId = rationFoodId;
    }

    public Ration getRation() {
        return ration;
    }

    public void setRation(Ration ration) {
        this.ration = ration;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
}
