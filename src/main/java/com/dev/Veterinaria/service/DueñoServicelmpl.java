package com.dev.Veterinaria.service;

import com.dev.Veterinaria.model.Dueño;
import com.dev.Veterinaria.repository.DueñoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Service
public class DueñoServicelmpl implements DueñoService{
    @Autowired
    private DueñoRepository repository;

    @Override
    @Transactional
    public void insert(Dueño dueño) {
        repository.save(dueño);
    }

    @Override
    @Transactional
    public void update(Dueño dueño) {
        repository.save(dueño);
    }

    @Override
    @Transactional
    public void delete(long  id_dueño ) {
        repository.deleteById( id_dueño);
    }

    @Override
    @Transactional(readOnly = true)
    public Dueño findById(long  id_dueño) {
        return repository.findById( id_dueño).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Dueño> findAll(){
        return (Collection<Dueño>)repository.findAll();
    }
}
