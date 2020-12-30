package ec.edu.ups.aporte_ahorros;

import java.io.Serializable;

public class TipoMovimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private boolean suma;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isSuma() {
		return suma;
	}
	public void setSuma(boolean suma) {
		this.suma = suma;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
