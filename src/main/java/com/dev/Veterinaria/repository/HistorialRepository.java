package com.dev.Veterinaria.repository;

import com.dev.Veterinaria.model.Historial;
import com.dev.Veterinaria.model.Mascota;
import org.springframework.data.repository.CrudRepository;

public interface HistorialRepository extends CrudRepository<Historial,Long> {
}
