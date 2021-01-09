package ec.edu.ups.socios;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="CDA_PlanCuenta")
public class PlanCuentas implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false)
	private String tipo;
	@Column(nullable=false)
	private String descrip;
	
	@ManyToOne
	@JoinColumn
	private CuentaAhorros cuentaA;
	
	
	public PlanCuentas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PlanCuentas(int id, String tipo, String descrip, CuentaAhorros cuentaA) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descrip = descrip;
		this.cuentaA = cuentaA;
	}

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
	
	public CuentaAhorros getCuentaA() {
		return cuentaA;
	}

	public void setCuentaA(CuentaAhorros cuentaA) {
		this.cuentaA = cuentaA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
