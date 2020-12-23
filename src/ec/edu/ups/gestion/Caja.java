package ec.edu.ups.gestion;

import java.io.Serializable;

public class Caja implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String direccion;
	private float saldo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
