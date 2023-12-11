package com.dev.Veterinaria.service;

import com.dev.Veterinaria.model.Mascota;
import com.dev.Veterinaria.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class MascotaServiceImpl implements MascotaService{
    @Autowired
    private MascotaRepository repository;

    @Override
    @Transactional
    public void insert(Mascota mascota) {
        repository.save(mascota);
    }

    @Override
    @Transactional
    public void update(Mascota mascota) {
        repository.save(mascota);
    }

    @Override
    @Transactional
    public void delete(long mascotaId) {
        repository.deleteById(mascotaId);
    }

    @Override
    @Transactional(readOnly = true)
    public Mascota findById(long mascotaId) {
        return repository.findById(mascotaId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Mascota> findAll(){
        return (Collection<Mascota>)repository.findAll();
    }

}
