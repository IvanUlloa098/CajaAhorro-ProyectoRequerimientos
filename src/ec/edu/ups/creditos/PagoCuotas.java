package ec.edu.ups.creditos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="CDA_PagoCuotas")
public class PagoCuotas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false)
	private double montoPag;
	@Column(nullable=false)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn
	private Credito credito ;
	
	public PagoCuotas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PagoCuotas(int id, double montoPag, Date fecha, Credito credito) {
		super();
		this.id = id;
		this.montoPag = montoPag;
		this.fecha = fecha;
		this.credito = credito;
	}
	
	public boolean verificarCredito() {
		
		if(this.credito.getEstado() == 'A' ) {
			return true;
		} else {
			return false;
		}
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMontoPag() {
		return montoPag;
	}
	public void setMontoPag(double montoPag) {
		this.montoPag = montoPag;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Credito getCredito() {
		return credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
