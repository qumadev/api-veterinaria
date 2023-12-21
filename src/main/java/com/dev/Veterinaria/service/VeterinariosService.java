package com.dev.Veterinaria.service;



import com.dev.Veterinaria.model.Veterinarios;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface VeterinariosService {


    public abstract void insert(Veterinarios veterinarios);
    public abstract void update(Veterinarios veterinarios);
    public abstract void delete(Long id_veterinario);


    public abstract Veterinarios findById(Long idVeterinario);
    public abstract Collection<Veterinarios> findAll();

}
