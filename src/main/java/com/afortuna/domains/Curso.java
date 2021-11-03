package com.afortuna.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {

	// Atributos
	// ===========================================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nombre;

	@OneToMany(mappedBy = "curso", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Alumno> alumnos;

	// Constructores
	// ===========================================================================

	public Curso() {

	}

	public Curso(final Long id, final String nombre, final List<Alumno> alumnos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	// Getters y Setters
	// ===========================================================================

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(final List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
