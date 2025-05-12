package com.billgym.pe.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="correo")
	private String correo;
	
	
	@Column(name="tiempo_suscripcion")
	private String tiempoSuscripcion;
	
	@Column(name="direccion")
	private String direccion;
	
	
	@JoinColumn(name="id_sede")
	private Integer id_sede;
	
	@Column(name="fecha")
	private java.sql.Date fecha;

	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, String apellidos, String dni, int edad, String telefono, String correo,
			String tiempoSuscripcion, String direccion, Integer id_sede, Date fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.tiempoSuscripcion = tiempoSuscripcion;
		this.direccion = direccion;
		this.id_sede = id_sede;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTiempoSuscripcion() {
		return tiempoSuscripcion;
	}

	public void setTiempoSuscripcion(String tiempoSuscripcion) {
		this.tiempoSuscripcion = tiempoSuscripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getId_sede() {
		return id_sede;
	}

	public void setId_sede(Integer id_sede) {
		this.id_sede = id_sede;
	}

	public java.sql.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", edad="
				+ edad + ", telefono=" + telefono + ", correo=" + correo + ", tiempoSuscripcion=" + tiempoSuscripcion
				+ ", direccion=" + direccion + ", id_sede=" + id_sede + ", fecha=" + fecha + "]";
	}

	
	
	
	

	}