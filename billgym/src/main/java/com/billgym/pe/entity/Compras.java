package com.billgym.pe.entity;

import java.math.BigDecimal;
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
@Table(name="compras")
public class Compras {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_compras")
	private int id_compras;
	
	@Column(name="id_producto")
	private int id_producto;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="precio_unitario")
	private BigDecimal precio_unitario;
	
	@Column(name="fecha_compra")
	private java.sql.Date fecha_compra;
	
	@Column(name="id_proveedor")
	private int id_provedor;
	
	// RELACION ENTRE ENTIDAD PRODUCTO
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

	public Compras() {
		super();
	}

	public Compras(int id_compras, int id_producto, int cantidad, BigDecimal precio_unitario, Date fecha_compra,
			int id_provedor, Producto producto) {
		super();
		this.id_compras = id_compras;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.fecha_compra = fecha_compra;
		this.id_provedor = id_provedor;
		this.producto = producto;
	}

	public int getId_compras() {
		return id_compras;
	}

	public void setId_compras(int id_compras) {
		this.id_compras = id_compras;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(BigDecimal precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public java.sql.Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(java.sql.Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public int getId_provedor() {
		return id_provedor;
	}

	public void setId_provedor(int id_provedor) {
		this.id_provedor = id_provedor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Compras [id_compras=" + id_compras + ", id_producto=" + id_producto + ", cantidad=" + cantidad
				+ ", precio_unitario=" + precio_unitario + ", fecha_compra=" + fecha_compra + ", id_provedor="
				+ id_provedor + ", producto=" + producto + "]";
	}
    
    
    
    
}