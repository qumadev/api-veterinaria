package com.dev.Veterinaria.service;

import com.dev.Veterinaria.model.Vacuna;
import com.dev.Veterinaria.repository.VacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class VacunaServiceImpl implements VacunaService {
    @Autowired
    private VacunaRepository repository;

    @Override
    @Transactional
    public void insert(Vacuna vacuna) {
        repository.save(vacuna);
    }

    @Override
    @Transactional
    public void update(Vacuna vacuna) {
        repository.save(vacuna);
    }

    @Override
    @Transactional
    public void delete(long vacunaId) {
        repository.deleteById(vacunaId);
    }

    @Override
    @Transactional(readOnly = true)
    public Vacuna findById(long vacunaId) {
        return repository.findById(vacunaId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Vacuna> findAll(){
        return (Collection<Vacuna>)repository.findAll();
    }
}
