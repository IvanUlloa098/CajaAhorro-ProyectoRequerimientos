package ec.edu.ups.socios;

import java.io.Serializable;

public class PlanCuentas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String tipo;
	private String descrip;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
