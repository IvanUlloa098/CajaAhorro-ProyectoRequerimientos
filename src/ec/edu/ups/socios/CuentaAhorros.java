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
	private int cuentaId;
	@Column(nullable=false)
	private int numeroCta;
	@Column(nullable=false)
	private Date fechaCre;
	@Column(nullable=false)
	private char cuentaAct;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaA")
	private Set<Movimiento>movimiento = new HashSet<Movimiento>();
	
	@ManyToOne
	@JoinColumn
	private Socio socio;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaA")
	private Set<PlanCuentas>planCuentas = new HashSet<PlanCuentas>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaA")
	private Set<SolicitudCredito>solicitudCredito= new HashSet<SolicitudCredito>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaA")
	private Set<Credito> credito = new HashSet<Credito>();
	
	private double inicial;
	
	private double saldo;
	
	private Movimiento m;
	
	private Caja c;
	
	public CuentaAhorros() {
		
	}
	
	public CuentaAhorros(int cuentaId, int numeroCta, Date fechaCre, char cuentaAct, Socio socio) {
		super();
		this.cuentaId = cuentaId;
		this.numeroCta = numeroCta;
		this.fechaCre = fechaCre;
		this.cuentaAct = cuentaAct;
		this.socio = socio;
	}
	
	public int getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(int cuentaId) {
		this.cuentaId = cuentaId;
	}
	public int getNumeroCta() {
		return numeroCta;
	}
	public void setNumeroCta(int numeroCta) {
		this.numeroCta = numeroCta;
	}
	public Date getFechaCre() {
		return fechaCre;
	}
	public void setFechaCre(Date fechaCre) {
		this.fechaCre = fechaCre;
	}
	public char getCuentaAct() {
		return cuentaAct;
	}
	public void setCuentaAct(char cuentaAct) {
		this.cuentaAct = cuentaAct;
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

	public Set<PlanCuentas> getPlanCuentas() {
		return planCuentas;
	}

	public void setPlanCuentas(Set<PlanCuentas> planCuentas) {
		this.planCuentas = planCuentas;
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
