package ec.edu.ups.creditos;

import java.io.Serializable;
import java.util.Date;
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
	private double monto;
	@Column(nullable=false)
	private int interes;
	@Column(nullable=false)
	private int numeroCuota;
	@Column(nullable=false)
	private char estado;
	
	private Date fecha;
	
	
	@ManyToOne
	@JoinColumn
	private CuentaAhorros cuentaA;
	
	@ManyToOne
	@JoinColumn
	private CarteraCreditos carteraC;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "credito")
	private Set<TablaAmortizacion>tablaAmortizacion  = new HashSet<TablaAmortizacion>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "credito")
	private Set<PagoCuotas> pagos = new HashSet<PagoCuotas>();
	
	public Credito() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Credito(int id, double monto, int interes, int numeroCuota, char estado, CuentaAhorros cuentaA,
			CarteraCreditos carteraC) {
		super();
		this.id = id;
		this.monto = monto;
		this.interes = interes;
		this.numeroCuota = numeroCuota;
		this.estado = estado;
		this.cuentaA = cuentaA;
		this.carteraC = carteraC;
	}
	
	public Credito(double monto, int interes, int numeroCuota, char estado, Date fecha, CuentaAhorros cuentaA,
			CarteraCreditos carteraC) {
		super();
		this.monto = monto;
		this.interes = interes;
		this.numeroCuota = numeroCuota;
		this.estado = estado;
		this.fecha = fecha;
		this.cuentaA = cuentaA;
		this.carteraC = carteraC;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
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
	
	public CuentaAhorros getCuentaA() {
		return cuentaA;
	}

	public void setCuentaA(CuentaAhorros cuentaA) {
		this.cuentaA = cuentaA;
	}

	public CarteraCreditos getCarteraC() {
		return carteraC;
	}

	public void setCarteraC(CarteraCreditos carteraC) {
		this.carteraC = carteraC;
	}


	public Set<TablaAmortizacion> getTablaAmortizacion() {
		return tablaAmortizacion;
	}

	public void setTablaAmortizacion(Set<TablaAmortizacion> tablaAmortizacion) {
		this.tablaAmortizacion = tablaAmortizacion;
	}

	public Set<PagoCuotas> getPagos() {
		return pagos;
	}

	public void setPagos(Set<PagoCuotas> pagos) {
		this.pagos = pagos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	private double calcularTEM(double tea, int dias) {
        return (double) (Math.pow(1f + (tea / 100f), dias / 360f) - 1f) * 100f;
    }
	
	public double calcularCuota(double tea, double cuotas, double monto) {
		 double tem = this.calcularTEM(tea, 30) / 100f;

        double x = (double) Math.pow(1f + tem, cuotas);
        return monto * ((x * tem) / (x - 1f));
    }

}
