package com.foodsmile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsmile.model.Ration;

public interface RationRepository extends JpaRepository<Ration, Integer> {
}
