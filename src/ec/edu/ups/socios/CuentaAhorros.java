package ec.edu.ups.socios;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.SolicitudCredito;

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
	private Set<CuentaAhorros>cuentaAhorros = new HashSet<CuentaAhorros>();
	
	@ManyToOne
	@JoinColumn
	private Socio socio;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaA")
	private Set<PlanCuentas>planCuentas = new HashSet<PlanCuentas>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaA")
	private Set<SolicitudCredito>solicitudCredito= new HashSet<SolicitudCredito>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaA")
	private Set<Credito> credito = new HashSet<Credito>();
	
	
	public CuentaAhorros() {
		
	}
	
	public CuentaAhorros(int cuentaId, int numeroCta, Date fechaCre, char cuentaAct, Set<CuentaAhorros> cuentaAhorros,
			Socio socio) {
		super();
		this.cuentaId = cuentaId;
		this.numeroCta = numeroCta;
		this.fechaCre = fechaCre;
		this.cuentaAct = cuentaAct;
		this.cuentaAhorros = cuentaAhorros;
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
	
	public Set<CuentaAhorros> getCuentaAhorros() {
		return cuentaAhorros;
	}

	public void setCuentaAhorros(Set<CuentaAhorros> cuentaAhorros) {
		this.cuentaAhorros = cuentaAhorros;
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

	public void setCredito(Set<Credito> credito) {
		this.credito = credito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
