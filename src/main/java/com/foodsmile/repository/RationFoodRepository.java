package com.foodsmile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsmile.model.RationFood;

public interface RationFoodRepository extends JpaRepository<RationFood, Integer> {
}
