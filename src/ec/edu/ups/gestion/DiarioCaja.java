package ec.edu.ups.gestion;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import ec.edu.ups.aporte_ahorros.Movimiento;

@Entity
@Table(name="CDA_DiarioCaja")
public class DiarioCaja implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn()
	private Caja caja;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "diarioCaja")
	private Set<Movimiento> movimiento = new HashSet<Movimiento>();
	
	public DiarioCaja() {
		
	}
	
	public DiarioCaja(Date fecha, Caja caja, Set<Movimiento> movimiento) {
		super();
		this.fecha = fecha;
		this.caja = caja;
		this.movimiento = movimiento;
	}

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
	
	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
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
	
	
	

}
