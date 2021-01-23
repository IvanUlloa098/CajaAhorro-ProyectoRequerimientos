 package ec.edu.ups.socios;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import ec.edu.ups.aporte_ahorros.Movimiento;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.gestion.Caja;

@Entity
@Table(name="CDA_CuentaAhorros")
public class CuentaAhorros implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false, unique=true)
	private String numero;
	@Column(nullable=false)
	private Date fechaCreacion;
	@Column(nullable=false)
	private char estado;
	@Column(nullable=false)
	private double saldo;
	
	@ManyToOne
	@JoinColumn
	private PlanCuentas planesCuentas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaA")
	private Set<Movimiento>movimiento = new HashSet<Movimiento>();
	
	@ManyToOne
	@JoinColumn
	private Socio socio;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaA")
	private Set<SolicitudCredito>solicitudCredito= new HashSet<SolicitudCredito>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaA")
	private Set<Credito> credito = new HashSet<Credito>();
	
	@Transient
	private double inicial;
	
	
	public CuentaAhorros() {
		
	}
	
	public CuentaAhorros(int id, int numero, Date fechaCreacion, char estado, Socio socio, PlanCuentas planesCuentas) {
		super();
		this.id = id;
		this.numero = numero;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.socio = socio;
		this.planesCuentas=planesCuentas;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public Set<Movimiento> getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Set<Movimiento> movimiento) {
		this.movimiento = movimiento;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public PlanCuentas getPlanesCuentas() {
		return planesCuentas;
	}

	public void setPlanesCuentas(PlanCuentas planesCuentas) {
		this.planesCuentas = planesCuentas;
	}

	public Set<SolicitudCredito> getSolicitudCredito() {
		return solicitudCredito;
	}

	public void setSolicitudCredito(Set<SolicitudCredito> solicitudCredito) {
		this.solicitudCredito = solicitudCredito;
	}

	public Set<Credito> getCredito() {
		return credito;
	}
	
	public double getinicial() {
		return inicial;
	}
	public void setinicial(double inicial) {
		this.inicial = inicial;
	}

	public void setCredito(Set<Credito> credito) {
		this.credito = credito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
	public double addDeposito(double cantidad) {
		
		saldo = saldo + cantidad;
		//c.setSaldo((float) saldo);
		System.out.println("Deposito Realizado por: "+ cantidad);
		System.out.println("Saldo: "+ saldo);
		return saldo;
	}
	
	public double addRetiro(double cantidad) {
		
		saldo = saldo - cantidad;
		System.out.println("Retiro Realizado por: "+ cantidad);
		System.out.println("Saldo: "+ saldo);
		return saldo;
		
	}
	
	public boolean Transacciones(double cantidad, String tipotxn) {
		
		if(tipotxn == "Deposito")	
			{
				saldo = saldo + cantidad;
				System.out.println("Deposito Realizado por: "+ cantidad);
				System.out.println("Saldo: "+ saldo);
				return true;
			}
			
		if(tipotxn == "Retiro")
			{
				saldo = saldo - cantidad;
				System.out.println("Deposito Realizado por: "+ cantidad);
				System.out.println("Saldo: "+ saldo);
				return true;
			}
		if(tipotxn == "Transferencia")
		{
			saldo = saldo - cantidad;
			System.out.println("Deposito Realizado por: "+ cantidad);
			System.out.println("Saldo: "+ saldo);
			return true;
		}
		return false;
	}
	

}
