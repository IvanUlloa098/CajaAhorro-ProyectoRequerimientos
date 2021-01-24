package ec.edu.ups.aporte_ahorros;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.DiarioCaja;
import ec.edu.ups.socios.CuentaAhorros;

@Entity
@Table(name="CDA_Movimiento")
public class Movimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false)
	private Date fecha;
	@Column(nullable=false)
	private double monto;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "movimiento")
	private DiarioCaja diario;
	
	@ManyToOne
	@JoinColumn
	private TipoMovimiento tipoM;
	
	@ManyToOne
	@JoinColumn
	private CuentaAhorros cuentaA;
	
	public Movimiento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
/*	public Movimiento(int id, Date fecha, float monto, DiarioCaja diarioCaja, TipoMovimiento tipoM,
			CuentaAhorros cuentaA) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
		this.diarioCaja = diarioCaja;
		this.tipoM = tipoM;
		this.cuentaA = cuentaA;
	}*/
	public Movimiento(int id, Date fecha, double monto, TipoMovimiento tipoM) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
		this.tipoM = tipoM;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}

	public TipoMovimiento getTipoM() {
		return tipoM;
	}

	public CuentaAhorros getCuentaA() {
		return cuentaA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}


	public void setTipoM(TipoMovimiento tipoM) {
		this.tipoM = tipoM;
	}


	public void setCuentaA(CuentaAhorros cuentaA) {
		this.cuentaA = cuentaA;
	}


	public DiarioCaja getDiario() {
		return diario;
	}


	public void setDiario(DiarioCaja diario) {
		this.diario = diario;
	}
	
	

}
