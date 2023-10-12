package com.foodsmile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.foodsmile.model.Ration;
import com.foodsmile.service.RationService;

@RestController
@RequestMapping("/api/rations")
public class RationController {

    @Autowired
    private RationService service;

    @GetMapping
    public List<Ration> getAllRations() {
        return service.getAllRations();
    }

    @GetMapping("/{id}")
    public Ration getRationById(@PathVariable Integer id) {
        return service.getRationById(id);
    }

    @PostMapping
    public Ration createRation(@RequestBody Ration ration) {
        return service.createRation(ration);
    }

    @PutMapping
    public Ration updateRation(@RequestBody Ration ration) {
        return service.updateRation(ration);
    }

    @DeleteMapping("/{id}")
    public void deleteRation(@PathVariable Integer id) {
        service.deleteRation(id);
    }
}
