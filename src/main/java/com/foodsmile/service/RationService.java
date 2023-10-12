package com.foodsmile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.foodsmile.model.Ration;
import com.foodsmile.repository.RationRepository;

@Service
public class RationService {

    @Autowired
    private RationRepository repository;

    public List<Ration> getAllRations() {
        return repository.findAll();
    }

    public Ration getRationById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Ration createRation(Ration ration) {
        return repository.save(ration);
    }

    public Ration updateRation(Ration ration) {
        return repository.save(ration);
    }

    public void deleteRation(Integer id) {
        repository.deleteById(id);
    }
}
