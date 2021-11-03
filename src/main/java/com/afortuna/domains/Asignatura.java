package com.afortuna.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Asignatura {

	// Atributos
	// ===========================================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nombre;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Profesor> profesores;

	// Constructores
	// ===========================================================================

	public Asignatura() {

	}

	public Asignatura(final Long id, final String nombre, final List<Profesor> profesores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.profesores = profesores;
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

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(final List<Profesor> profesores) {
		this.profesores = profesores;
	}

}
