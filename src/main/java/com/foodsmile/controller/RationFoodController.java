package com.foodsmile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.foodsmile.model.RationFood;
import com.foodsmile.service.RationFoodService;

@RestController
@RequestMapping("/rationfoods")
public class RationFoodController {

    @Autowired
    private RationFoodService service;

    @GetMapping
    public List<RationFood> getAllRationFoods() {
        return service.getAllRationFoods();
    }

    @GetMapping("/{id}")
    public RationFood getRationFoodById(@PathVariable Integer id) {
        return service.getRationFoodById(id);
    }

    @PostMapping
    public RationFood createRationFood(@RequestBody RationFood rationFood) {
        return service.createRationFood(rationFood);
    }

    @PutMapping("/{id}")
    public RationFood updateRationFood(@PathVariable Integer id, @RequestBody RationFood rationFood) {
        rationFood.setRationFoodId(id);
        return service.updateRationFood(rationFood);
    }

    @DeleteMapping("/{id}")
    public void deleteRationFood(@PathVariable Integer id) {
        service.deleteRationFood(id);
    }
}
