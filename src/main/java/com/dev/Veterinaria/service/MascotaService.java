package com.dev.Veterinaria.service;

import com.dev.Veterinaria.model.Mascota;

import java.util.Collection;

public interface MascotaService {
    public abstract void insert(Mascota mascota);
    public abstract void update(Mascota mascota);
    public abstract void delete(long mascotaId);
    public abstract Mascota findById(long mascotaId);
    public abstract Collection<Mascota> findAll();
}
