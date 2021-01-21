package ec.edu.ups.gestion;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CDA_Rol")
public class Rol implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String rol;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "rol")
	private Usuario user ;
	
	
	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rol(int id, String rol) {
		super();
		this.id = id;
		this.rol = rol;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
