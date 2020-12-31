package ec.edu.ups.creditos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CDA_CarteraCreditos")
public class CarteraCreditos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;
	@Column(nullable=false)
	private char calificacion;
	@Column(nullable=false)
	private int diasMora;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "carteraC")
	private Set<CarteraCreditos>carteraCreditos= new HashSet<CarteraCreditos>();
	
	public CarteraCreditos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(char calificacion) {
		this.calificacion = calificacion;
	}
	public int getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(int diasMora) {
		this.diasMora = diasMora;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
