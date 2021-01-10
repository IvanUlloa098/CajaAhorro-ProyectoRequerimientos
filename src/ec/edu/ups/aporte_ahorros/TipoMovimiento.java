package ec.edu.ups.aporte_ahorros;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CDA_TipoMovimiento")
public class TipoMovimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private boolean suma;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoM")
	private Set<Movimiento>movimiento = new HashSet<Movimiento>();
	
	public TipoMovimiento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TipoMovimiento(int id, String nombre, boolean suma) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.suma = suma;
	}

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
	public Set<Movimiento> getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(Set<Movimiento> movimiento) {
		this.movimiento = movimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public boolean crearTipoMovimiento(int id, String nombre, boolean suma ) {
		
		this.setId(id);
		this.setNombre(nombre);
		this.setSuma(suma);
		return true;
	};
}
