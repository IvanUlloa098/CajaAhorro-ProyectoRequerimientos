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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "caja")
	private Set<Movimiento>movimiento = new HashSet<Movimiento>();
	
	public Caja() {
		super();
		// TODO Auto-generated constructor stub
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
