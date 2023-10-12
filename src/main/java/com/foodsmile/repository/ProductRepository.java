package com.foodsmile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsmile.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
