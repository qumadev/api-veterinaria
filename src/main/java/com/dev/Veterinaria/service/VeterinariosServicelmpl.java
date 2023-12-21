package com.dev.Veterinaria.service;


import com.dev.Veterinaria.model.Veterinarios;
import com.dev.Veterinaria.repository.VeterinariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Service
public class VeterinariosServicelmpl implements VeterinariosService{
    @Autowired
    private VeterinariosRepository repository;

    @Override
    @Transactional
    public void insert(Veterinarios veterinarios) {
        repository.save(veterinarios);
    }

    @Override
    @Transactional
    public void update(Veterinarios veterinarios) {
        repository.save(veterinarios);
    }

    @Override
    @Transactional
    public void delete(Long id_veterinario ) {
        repository.deleteById( id_veterinario);
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinarios findById(Long id_veterinario) {
        return repository.findById( id_veterinario).orElse(null);
    }



    @Override
    @Transactional(readOnly = true)
    public Collection<Veterinarios> findAll(){
        return (Collection<Veterinarios>)repository.findAll();
    }
}
