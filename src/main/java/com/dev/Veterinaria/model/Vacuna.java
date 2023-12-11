package com.dev.Veterinaria.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "vacuna")
public class Vacuna {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_vacuna;

    @Column
    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fecha_vencimiento;
    @Column
    private float costo;
    @OneToMany(mappedBy = "vacuna")
    private Collection<Historial> itemsHistorial = new ArrayList<>();
}
