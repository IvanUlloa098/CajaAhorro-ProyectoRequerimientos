package ec.edu.ups.aporte_ahorros;

import java.io.Serializable;
import java.util.Date;

public class Movimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date fecha;
	private float monto;
	
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
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
