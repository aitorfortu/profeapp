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

	// Atributos
	// ===========================================================================

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
			final Rol rol, final Float saldo, final List<Asignatura> asignaturas, final String eduacion,
			final String experiencia, final float precio, final String sobremi, final boolean online,
			final boolean verificado) {
		super(nombre, apellidos, email, contrasena, rol, saldo);
		this.asignaturas = asignaturas;
		this.educacion = eduacion;

	}

	public Profesor(final String nombre, final String apellidos, final String email, final String contrasena,
			final Float saldo, final List<Asignatura> asignaturas, final String eduacion, final String experiencia,
			final float precio, final String sobremi, final boolean online, final boolean verificado) {
		super(nombre, apellidos, email, contrasena, saldo);
		this.asignaturas = asignaturas;
		this.educacion = eduacion;

	}

	public Profesor(final String nombre, final String apellidos, final String email, final String contrasena,
			final Rol rol, final Float saldo) {
		super(nombre, apellidos, email, contrasena, rol, saldo);
	}

	// Getters y Setters
	// ===========================================================================

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(final List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public String getEducacion() {
		return educacion;
	}

	public void setEducacion(final String educacion) {
		this.educacion = educacion;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(final String experiencia) {
		this.experiencia = experiencia;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(final float precio) {
		this.precio = precio;
	}

	public String getSobremi() {
		return sobremi;
	}

	public void setSobremi(final String sobremi) {
		this.sobremi = sobremi;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(final boolean online) {
		this.online = online;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(final boolean verificado) {
		this.verificado = verificado;
	}

}
