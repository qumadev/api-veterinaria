package com.dev.Veterinaria.service;



import com.dev.Veterinaria.model.Dueño;

import java.util.Collection;

public interface DueñoService {
    public abstract void insert(Dueño dueño);
    public abstract void update(Dueño dueño);
    public abstract void delete(long id_dueño);
    public abstract Dueño findById(long id_dueño);
    public abstract Collection<Dueño> findAll();

}
