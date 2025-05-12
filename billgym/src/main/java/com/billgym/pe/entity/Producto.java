package com.billgym.pe.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int id_producto;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio_publico")
	private BigDecimal precio_publico;
	
	@Column(name="stock")
	private int stock;
	
	@Column(name="fecha_vencimiento")
	private java.sql.Date fecha_vencimiento;
	
	@Column(name="precio_compra")
	private BigDecimal precio_compra;

	public Producto() {
		super();
	}

	public Producto(int id_producto, String nombre, String descripcion, BigDecimal precio_publico, int stock,
			Date fecha_vencimiento, BigDecimal precio_compra) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio_publico = precio_publico;
		this.stock = stock;
		this.fecha_vencimiento = fecha_vencimiento;
		this.precio_compra = precio_compra;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio_publico() {
		return precio_publico;
	}

	public void setPrecio_publico(BigDecimal precio_publico) {
		this.precio_publico = precio_publico;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public java.sql.Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(java.sql.Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public BigDecimal getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(BigDecimal precio_compra) {
		this.precio_compra = precio_compra;
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio_publico=" + precio_publico + ", stock=" + stock + ", fecha_vencimiento=" + fecha_vencimiento
				+ ", precio_compra=" + precio_compra + "]";
	}
	
	
	

}
