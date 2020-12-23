package ec.edu.ups.gestion;

import java.io.Serializable;
import java.util.Date;

public class DiarioCaja implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date fecha;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
