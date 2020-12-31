package ec.edu.ups.creditos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="CDA_PagoCuotas")
public class RegistroPagoCuotas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false)
	private float montoPag;
	@Column(nullable=false)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn
	private Credito credito ;
	
	public RegistroPagoCuotas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegistroPagoCuotas(int id, float montoPag, Date fecha, Credito credito) {
		super();
		this.id = id;
		this.montoPag = montoPag;
		this.fecha = fecha;
		this.credito = credito;
	}

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
