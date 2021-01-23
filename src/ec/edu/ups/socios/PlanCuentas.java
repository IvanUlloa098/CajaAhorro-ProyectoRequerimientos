package ec.edu.ups.socios;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "planesCuentas")
	private Set<CuentaAhorros>cuentasAhorros = new HashSet<CuentaAhorros>();
	
	public PlanCuentas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PlanCuentas(int id, String tipo, String descrip) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descrip = descrip;
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

	public Set<CuentaAhorros> getCuentasAhorros() {
		return cuentasAhorros;
	}

	public void setCuentasAhorros(Set<CuentaAhorros> cuentasAhorros) {
		this.cuentasAhorros = cuentasAhorros;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
