package com.dev.Veterinaria.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "mascota")
public class Mascota {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_mascota;

    @Column
    private String nombre;

    @Column
    private String especie;

    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;

    @OneToMany(mappedBy = "mascota")
    private Collection<Historial> itemsHistorial = new ArrayList<>();

}
