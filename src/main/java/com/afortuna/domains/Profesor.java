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
public class Profesor extends Entidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Asignatura> asignaturas;

	@Column
	private String educacion;

	@Column
	private String experiencia;

	@Column
	private float precio;

	@Column
	private String sobremi;

	@Column
	private boolean online;

	@Column
	private boolean verificado;

	// Constructores
	// ===========================================================================

	public Profesor() {

	}

	public Profesor(final String nombre, final String apellidos, final String email, final String contrasena,
			final List<Asignatura> asignaturas, final String eduacion, final String experiencia, final float precio,
			final String sobremi, final boolean online, final boolean verificado) {
		super(nombre, apellidos, email, contrasena);
		this.asignaturas = asignaturas;
		this.educacion = eduacion;
	}
}
