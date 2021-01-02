package ec.edu.ups.socios;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import ec.edu.ups.gestion.Persona;

@Entity
@Table(name = "CDA_Socios")
public class Socio extends Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false)
	private char estado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
	private Set<CuentaAhorros>cuentaAhorros= new HashSet<CuentaAhorros>();
	
	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Socio(int id, char estado) {
		super();
		this.id = id;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
