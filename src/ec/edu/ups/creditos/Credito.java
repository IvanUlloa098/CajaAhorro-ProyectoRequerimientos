package ec.edu.ups.creditos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import ec.edu.ups.socios.CuentaAhorros;

@Entity
@Table(name="CDA_Credito")
public class Credito implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false)
	private float monto;
	@Column(nullable=false)
	private int interes;
	@Column(nullable=false)
	private int numeroCuota;
	@Column(nullable=false)
	private char estado;
	
	@ManyToOne
	@JoinColumn
	private CuentaAhorros cuentaA;
	
	@ManyToOne
	@JoinColumn
	private CarteraCreditos carteraC;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "credito")
	private Set<CarteraCreditos>carteraCreditos= new HashSet<CarteraCreditos>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "credito")
	private Set<TablaAmortizacion>tablaAmortizacion  = new HashSet<TablaAmortizacion>();
	
	
	public Credito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public int getInteres() {
		return interes;
	}
	public void setInteres(int interes) {
		this.interes = interes;
	}
	public int getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
