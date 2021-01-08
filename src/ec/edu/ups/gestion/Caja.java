package ec.edu.ups.gestion;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import ec.edu.ups.aporte_ahorros.Movimiento;

import javax.persistence.*;

@Entity
@Table(name="CDA_Caja")
public class Caja implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String direccion;
	@Column(nullable=false)
	private float saldo;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "caja")
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "caja")
	private Set<DiarioCaja> diarioCaja = new HashSet<DiarioCaja>();
	
	
	public Caja() {
		
	}
	
	public Caja(int id, String direccion, float saldo) {
		this.id = id;
		this.direccion = direccion;
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<DiarioCaja> getDiarioCaja() {
		return diarioCaja;
	}

	public void setDiarioCaja(Set<DiarioCaja> diarioCaja) {
		this.diarioCaja = diarioCaja;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
