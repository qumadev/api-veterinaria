package com.dev.Veterinaria.service;



import com.dev.Veterinaria.model.Veterinarios;

import java.util.Collection;

public interface VeterinariosService {
    public abstract void insert(Veterinarios veterinarios);
    public abstract void update(Veterinarios veterinarios);
    public abstract void delete(long  id_veterinario);
    public abstract Veterinarios findById(long  id_veterinario);
    public abstract Collection<Veterinarios> findAll();

}
