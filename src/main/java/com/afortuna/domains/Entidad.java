package com.afortuna.domains;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Entidad {
	@Column(insertable = false, updatable = false)
	private String dtype;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	protected String nombre;

	protected String apellidos;

	protected String contrasena;

	protected String localidad;

	protected Integer codigoPostal;

	@Column(unique = true)
	private Integer telefono;

	@Column(unique = true)
	private String email;
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Rol rol;

	// CONSTRUCTORES

	@Column(name = "imagen")
	private byte[] imagen;

	public Entidad() {

	}

	public Entidad(final String nombre, final String apellidos, final String email, final String contrasena,
			final Rol rol) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasena = contrasena;
		this.rol = rol;
	}

	public Entidad(final String nombre, final String apellidos, final String email, final String contrasena) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasena = contrasena;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(final String dtype) {
		this.dtype = dtype;
	}

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(final String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(final String contrasena) {
		this.contrasena = contrasena;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(final String localidad) {
		this.localidad = localidad;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(final Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(final Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(final Rol rol) {
		this.rol = rol;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(final byte[] imagen) {
		this.imagen = imagen;
	}

}
