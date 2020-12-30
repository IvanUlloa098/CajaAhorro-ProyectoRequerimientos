package ec.edu.ups.socios;

import java.io.Serializable;

import ec.edu.ups.gestion.Persona;

public class Socio extends Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private char estado;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	
	
	
}
