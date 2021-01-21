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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="CDA_Usuario")
@PrimaryKeyJoinColumn(name="persona_id")
public class Usuario extends Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;**/
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@OneToOne
	@JoinColumn
	private Rol rol;
	
	@ManyToOne
	@JoinColumn
	private Caja caja;
		
	
	public Usuario() {
	
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String username, String password, Rol rol, Caja caja) {
		
		this.username = username;
		this.password = password;
		this.rol = rol;
		this.caja = caja;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
