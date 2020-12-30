package ec.edu.ups.creditos;

import java.io.Serializable;

public class CarteraCreditos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private char calificacion;
	private int diasMora;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(char calificacion) {
		this.calificacion = calificacion;
	}
	public int getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(int diasMora) {
		this.diasMora = diasMora;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
