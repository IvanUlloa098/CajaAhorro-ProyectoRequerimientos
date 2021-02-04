package ec.edu.ups.creditos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.edu.ups.socios.CuentaAhorros;

@Entity
@Table(name="CDA_SolicitudCredito")
public class SolicitudCredito implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false)
	private char estado;
	@Column(nullable=false)
	private Date fecha;
	@Column(nullable=false)
	private String observacion;
	
	@Column(nullable=false)
	private Double monto;
	
	private int cuotas;
	
	@ManyToOne
	@JoinColumn
	private CuentaAhorros cuentaA;
	
	public SolicitudCredito() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SolicitudCredito(int id, char estado, Date fecha, String observacion, CuentaAhorros cuentaA) {
		super();
		this.id = id;
		this.estado = estado;
		this.fecha = fecha;
		this.observacion = observacion;
		this.cuentaA = cuentaA;
	}
	
	public SolicitudCredito(char estado, Date fecha, Double monto, String observacion, CuentaAhorros cuentaA, int cuotas) {
		super();
		this.estado = estado;
		this.fecha = fecha;
		this.monto = monto;
		this.observacion = observacion;
		this.cuentaA = cuentaA;
		this.cuotas = cuotas;
	}
	
	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public CuentaAhorros getCuentaA() {
		return cuentaA;
	}

	public void setCuentaA(CuentaAhorros cuentaA) {
		this.cuentaA = cuentaA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	
}
