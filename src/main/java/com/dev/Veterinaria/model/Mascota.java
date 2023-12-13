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
    //nueva linea agregada//
    @ManyToOne
    @JoinColumn(name = "id_dueño")
    private Dueño dueño;

    @OneToMany(mappedBy = "mascota")
    private Collection<Historial> itemsHistorial = new ArrayList<>();

    public Long getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(Long id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Collection<Historial> getItemsHistorial() {
        return itemsHistorial;
    }

    public void setItemsHistorial(Collection<Historial> itemsHistorial) {
        this.itemsHistorial = itemsHistorial;
    }

    public Mascota() {
    }

    public Mascota(Long id_mascota, String nombre, String especie, Date fecha_nacimiento) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.especie = especie;
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
