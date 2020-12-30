package ec.edu.ups.creditos;

import java.io.Serializable;
import java.util.Date;

public class SolicitudCredito implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private char estado;
	private Date fecha;
	private String observacion;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
