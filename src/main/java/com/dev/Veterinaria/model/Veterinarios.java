package com.dev.Veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Veterinarios")
public class Veterinarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_veterinario;

    @Column
    private String nombre;

    @Column
    private String especialidad;

    @OneToMany(mappedBy = "veterinario")
    private List<Vacuna> vacunas;

    public Veterinarios() {
    }

    public Veterinarios(Long id_veterinario, String nombre, String especialidad, List<Vacuna> vacunas) {
        this.id_veterinario = id_veterinario;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.vacunas = vacunas;
    }

    public Long getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(Long id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }
}
