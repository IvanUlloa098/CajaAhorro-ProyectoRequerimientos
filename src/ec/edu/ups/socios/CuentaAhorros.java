package ec.edu.ups.socios;

import java.io.Serializable;
import java.util.Date;

public class CuentaAhorros implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cuentaId;
	private int numeroCta;
	private Date fechaCre;
	private char cuentaAct;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
