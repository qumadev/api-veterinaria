package com.dev.Veterinaria.service;

import com.dev.Veterinaria.model.Vacuna;

import java.util.Collection;

public interface VacunaService {
    public abstract void insert(Vacuna vacuna);
    public abstract void update(Vacuna vacuna);
    public abstract void delete(long vacunaId);
    public abstract Vacuna findById(long vacunaId);
    public abstract Collection<Vacuna> findAll();
}
