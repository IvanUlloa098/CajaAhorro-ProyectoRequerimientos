package ec.edu.ups.creditos;

import java.io.Serializable;
import java.util.Date;

public class TablaAmortizacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int numCuota;
	private Date fechaVenc;
	private Date fechaPag;
	private float capital;
	private int cuotas;
	private float interes;
	private float saldo;
	
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
	public Date getFechaPag() {
		return fechaPag;
	}
	public void setFechaPag(Date fechaPag) {
		this.fechaPag = fechaPag;
	}
	public float getCapital() {
		return capital;
	}
	public void setCapital(float capital) {
		this.capital = capital;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public float getInteres() {
		return interes;
	}
	public void setInteres(float interes) {
		this.interes = interes;
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
