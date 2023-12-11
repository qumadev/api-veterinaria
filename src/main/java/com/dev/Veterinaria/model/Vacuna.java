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

    public Long getId_vacuna() {
        return id_vacuna;
    }

    public void setId_vacuna(Long id_vacuna) {
        this.id_vacuna = id_vacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    public Vacuna() {
    }

    public Vacuna(Long id_vacuna, String nombre, Date fecha_vencimiento, float costo) {
        this.id_vacuna = id_vacuna;
        this.nombre = nombre;
        this.fecha_vencimiento = fecha_vencimiento;
        this.costo = costo;
    }
}
