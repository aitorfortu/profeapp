package com.afortuna.domains;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Alumno {

	// Atributos
	// ===========================================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaNacimiento;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Asignatura> asignaturas;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Curso curso;

	// Constructores
	// ===========================================================================

	public Alumno() {

	}

	public Alumno(final Long id, final LocalDate fechaNacimiento, final List<Asignatura> asignaturas,
			final Curso curso) {
		super();
		this.id = id;
		this.fechaNacimiento = fechaNacimiento;
		this.asignaturas = asignaturas;
		this.curso = curso;
	}

	// Getters y Setters
	// ===========================================================================

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(final List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(final Curso curso) {
		this.curso = curso;
	}

}
