package com.dev.Veterinaria.service;

import com.dev.Veterinaria.model.Historial;
import com.dev.Veterinaria.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class HistorialServiceImpl implements HistorialService{
    @Autowired
    private HistorialRepository repository;

    @Override
    @Transactional
    public void insert(Historial historial) {
        repository.save(historial);
    }

    @Override
    @Transactional
    public void update(Historial historial) {
        repository.save(historial);
    }

    @Override
    @Transactional
    public void delete(long historialId) {
        repository.deleteById(historialId);
    }

    @Override
    @Transactional(readOnly = true)
    public Historial findById(long historialId) {
        return repository.findById(historialId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Historial> findAll(){
        return (Collection<Historial>)repository.findAll();
    }
}
