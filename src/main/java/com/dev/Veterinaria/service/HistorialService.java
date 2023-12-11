package com.dev.Veterinaria.service;

import com.dev.Veterinaria.model.Historial;

import java.util.Collection;

public interface HistorialService {
    public abstract void insert(Historial historial);
    public abstract void update(Historial historial);
    public abstract void delete(long historialId);
    public abstract Historial findById(long historialId);
    public abstract Collection<Historial> findAll();
}
