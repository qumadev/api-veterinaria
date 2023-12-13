package com.dev.Veterinaria.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Dueño")
public class Dueño {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_dueño;

	@Column
	private String nombre;

	@Column
	private int telefono;

	@OneToMany(mappedBy = "dueño", cascade = CascadeType.ALL)
	private List<Mascota> mascotas;

	public Dueño() {
	}

	public Dueño(Long id_dueño, String nombre, int telefono, List<Mascota> mascotas) {
		this.id_dueño = id_dueño;
		this.nombre = nombre;
		this.telefono = telefono;
		this.mascotas = mascotas;
	}

	public Long getId_dueño() {
		return id_dueño;
	}

	public void setId_dueño(Long id_dueño) {
		this.id_dueño = id_dueño;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
}
