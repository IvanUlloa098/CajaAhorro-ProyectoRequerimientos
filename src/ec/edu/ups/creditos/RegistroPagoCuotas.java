package ec.edu.ups.creditos;

import java.io.Serializable;
import java.util.Date;

public class RegistroPagoCuotas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private float montoPag;
	private Date fecha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMontoPag() {
		return montoPag;
	}
	public void setMontoPag(float montoPag) {
		this.montoPag = montoPag;
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
