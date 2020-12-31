package ec.edu.ups.gestion;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CDA_Usuario")
public class Usuario extends Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Rol rol;
	
	@ManyToOne
	@JoinColumn
	private Caja caja;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(int id, String username, String password, Rol rol, Caja caja) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rol = rol;
		this.caja = caja;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
