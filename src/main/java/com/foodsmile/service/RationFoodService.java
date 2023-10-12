package com.foodsmile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RationFoodService {

    @Autowired
    private RationFoodRepository repository;

    public List<RationFood> getAllRationFoods() {
        return repository.findAll();
    }

    public RationFood getRationFoodById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public RationFood createRationFood(RationFood rationFood) {
        return repository.save(rationFood);
    }

    public RationFood updateRationFood(RationFood rationFood) {
        return repository.save(rationFood);
    }

    public void deleteRationFood(Integer id) {
        repository.deleteById(id);
    }
}
