package ec.edu.ups.socios;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import ec.edu.ups.gestion.Persona;

@Entity
@Table(name = "CDA_Socios")
@PrimaryKeyJoinColumn(name="persona_id")
public class Socio extends Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;**/
	
	@Column(nullable=false)
	private char estado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
	private Set<CuentaAhorros>cuentaAhorros= new HashSet<CuentaAhorros>();
	
	
	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Socio(char estado) {
		super();
		this.estado = estado;
	}
	
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	public Set<CuentaAhorros> getCuentaAhorros() {
		return cuentaAhorros;
	}

	public void setCuentaAhorros(Set<CuentaAhorros> cuentaAhorros) {
		this.cuentaAhorros = cuentaAhorros;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
