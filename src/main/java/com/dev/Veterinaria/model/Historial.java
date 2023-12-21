package com.dev.Veterinaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public Long getId_historial() {
        return id_historial;
    }

    public void setId_historial(Long id_historial) {
        this.id_historial = id_historial;
    }

    public Date getFecha_atencion() {
        return fecha_atencion;
    }

    public void setFecha_atencion(Date fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public Historial() {
    }

    public Historial(Long id_historial, Date fecha_atencion, Mascota mascota, Vacuna vacuna) {
        this.id_historial = id_historial;
        this.fecha_atencion = fecha_atencion;
        this.mascota = mascota;
        this.vacuna = vacuna;
    }
}
