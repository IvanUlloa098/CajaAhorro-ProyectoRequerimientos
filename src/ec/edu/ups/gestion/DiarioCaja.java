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
		super();
		// TODO Auto-generated constructor stub
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
