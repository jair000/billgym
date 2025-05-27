package com.billgym.pe.entity;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="loguin")
public class Loguin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_loguin")
	private int id_loguin;
	
	@Column(name="id_usuario")
	private int id_usuario;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="password")
	private String password;
	
	//RELACION ENTRE ENTIDADES 
	//RELACION CON ENTIDAD  USUARIO
	@ManyToOne
	@JoinColumn(name = "id",insertable = false, updatable = false)
	private Usuario usuarioDato;

	public Loguin() {
		super();
	}

	public Loguin(int id_loguin, int id_usuario, String usuario, String password, Usuario usuarioDato) {
		super();
		this.id_loguin = id_loguin;
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.password = password;
		this.usuarioDato = usuarioDato;
	}

	public int getId_loguin() {
		return id_loguin;
	}

	public void setId_loguin(int id_loguin) {
		this.id_loguin = id_loguin;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario getUsuarioDato() {
		return usuarioDato;
	}

	public void setUsuarioDato(Usuario usuarioDato) {
		this.usuarioDato = usuarioDato;
	}

	@Override
	public String toString() {
		return "Loguin [id_loguin=" + id_loguin + ", id_usuario=" + id_usuario + ", usuario=" + usuario + ", password="
				+ password + ", usuarioDato=" + usuarioDato + "]";
	}
	
}