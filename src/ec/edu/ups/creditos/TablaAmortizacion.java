package ec.edu.ups.creditos;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name="CDA_TablaAmortizacion")
public class TablaAmortizacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false)
	private int numCuota;
	@Column(nullable=false)
	private Date fechaVenc;
	@Column(nullable=false)
	private int tasa;
	@Column(nullable=false)
	private double capital;
	@Column(nullable=false)
	private double interes;
	@Column(nullable=false)
	private double pagoTotal;
	@Column(nullable=false)
	private double saldo;
	@Column(nullable=false)
	private String estado;
	
	
	@ManyToOne
	@JoinColumn
	private Credito credito;
	
	public TablaAmortizacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TablaAmortizacion(int id, int numCuota, Date fechaVenc, int  tasa, double capital,
			double interes, double pagoTotal, double saldo, String estado, Credito credito) {
		super();
		this.id = id;
		this.numCuota = numCuota;
		this.fechaVenc = fechaVenc;
		this.tasa = tasa;
		this.capital = capital;
		this.interes = interes;
		this.pagoTotal = pagoTotal;
		this.saldo = saldo;
		this.estado = estado;
		this.credito = credito;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumCuota() {
		return numCuota;
	}
	public void setNumCuota(int numCuota) {
		this.numCuota = numCuota;
	}
	public Date getFechaVenc() {
		return fechaVenc;
	}
	public void setFechaVenc(Date fechaVenc) {
		this.fechaVenc = fechaVenc;
	}
	
	public int getTasa() {
		return tasa;
	}

	public void setTasa(int tasa) {
		this.tasa = tasa;
	};
	
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
	
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	public double getPagoTotal() {
		return pagoTotal;
	}


	public void setPagoTotal(double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}
	
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Credito getCredito() {
		return credito;
	}


	public void setCredito(Credito credito) {
		this.credito = credito;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	public double calculaCapital() {
		
		double obtenerCapital = (double) pagoTotal-interes;
		//System.out.println(obtenerCapital);
		return obtenerCapital;
	};
	
	public double calculaInteres() {
		double obtenerTasa = (double) tasa/100;
		double obtenerInteres = (double) (saldo*obtenerTasa);
		//System.out.println(obtenerTasa);
		//System.out.println(obtenerInteres);
		return obtenerInteres;
	};
	
	public double calculaPagoTotal() {
		
		double obtenerTasa = (double) tasa/100;
		double obtenerPagoTotal = (double) (saldo*obtenerTasa)/( 1-Math.pow((1+obtenerTasa), -numCuota)); 
		//System.out.println( tasaInteres);
		//System.out.println(obtenerPagoTotal);
		return obtenerPagoTotal;
		
	}
	

	public double calculaSaldo() {
		double obtenerSaldo = (double) saldo-this.getCapital();
		//System.out.println(obtenerTasa);
		//System.out.println(obtenerCapital);
		//System.out.println(obtenerSaldo);
		return obtenerSaldo;
		
	}

	public double calculaPagoUnaCuota(int cuota) {
		double obtenerSaldo=0.0;
		
		double obtenerTasa = (double) tasa/100;
		double obtenerPagoTotal = (double) (saldo*obtenerTasa)/( 1-Math.pow((1+obtenerTasa), -numCuota)); 
		this.setPagoTotal(obtenerPagoTotal);
		
		for( int i=1; i<= cuota; i++) {
		
		double obtenerInteres = (double) (saldo*obtenerTasa);
		this.setInteres(obtenerInteres);
		
		double obtenerCapital = (double) pagoTotal-interes;
		this.setCapital(obtenerCapital);
		
		
		obtenerSaldo = (double) saldo-this.getCapital();
		this.setSaldo(obtenerSaldo);

		System.out.println("---------------");
		System.out.println("Capital  " +obtenerCapital);
		System.out.println("Interes  " +obtenerInteres);
		System.out.println("Pago total  " +  obtenerPagoTotal);
		System.out.println("saldo  "  +obtenerSaldo);
		}

		return obtenerSaldo;
	}
	

	
	
	

}
