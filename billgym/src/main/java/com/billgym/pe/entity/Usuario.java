package com.billgym.pe.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="f_nacimiento")
	private java.sql.Date f_nacimiento;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="f_contratacion")
	private java.sql.Date f_contratacion;
	
	@Column(name="rol")
	@Enumerated(EnumType.STRING)
	private RolUsuario rol;
	
	@Column(name="turno")
	private String turno;
	
	@Column(name="salario")
	private BigDecimal salario;
	
	@Column(name="activo", nullable = false)
	private Boolean estado;
	
	@JoinColumn(name="id_sede")
	private Integer id_sede;
	//CONTRUCTOR VACIO

	public Usuario() {
		super();
	}
	public Usuario(int id, String nombres, String apellidos, String dni, java.sql.Date f_nacimiento, String direccion,
			String telefono, String correo, java.sql.Date f_contratacion, RolUsuario rol, String turno,
			BigDecimal salario, Boolean estado, Integer id_sede) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.f_nacimiento = f_nacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.f_contratacion = f_contratacion;
		this.rol = rol;
		this.turno = turno;
		this.salario = salario;
		this.estado = estado;
		this.id_sede = id_sede;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
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
	public java.sql.Date getF_nacimiento() {
		return f_nacimiento;
	}
	public void setF_nacimiento(java.sql.Date f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public java.sql.Date getF_contratacion() {
		return f_contratacion;
	}
	public void setF_contratacion(java.sql.Date f_contratacion) {
		this.f_contratacion = f_contratacion;
	}
	public RolUsuario getRol() {
		return rol;
	}
	public void setRol(RolUsuario rol) {
		this.rol = rol;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Integer getId_sede() {
		return id_sede;
	}
	public void setId_sede(Integer id_sede) {
		this.id_sede = id_sede;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", f_nacimiento=" + f_nacimiento + ", direccion=" + direccion + ", telefono=" + telefono + ", correo="
				+ correo + ", f_contratacion=" + f_contratacion + ", rol=" + rol + ", turno=" + turno + ", salario="
				+ salario + ", estado=" + estado + ", id_sede=" + id_sede + "]";
	}
	

	}