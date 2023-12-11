package com.dev.Veterinaria.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "historial")
public class Historial {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_historial;
    @Temporal(TemporalType.DATE)
    private Date fecha_atencion;
    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable=false,
            foreignKey=@ForeignKey(foreignKeyDefinition =
                    "foreign key(id_mascota) references mascota(id_mascota)"))
    private Mascota mascota;
    @ManyToOne
    @JoinColumn(name = "id_vacuna", nullable=false,
            foreignKey=@ForeignKey(foreignKeyDefinition =
                    "foreign key(id_vacuna) references vacuna(id_vacuna)"))
    private Vacuna vacuna;
}
