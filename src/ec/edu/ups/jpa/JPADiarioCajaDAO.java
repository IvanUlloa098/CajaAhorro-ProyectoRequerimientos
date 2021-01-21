package ec.edu.ups.jpa;

import ec.edu.ups.dao.DiarioCajaDAO;
import ec.edu.ups.gestion.DiarioCaja;

public class JPADiarioCajaDAO extends JPAGenericDAO<DiarioCaja, Integer> implements DiarioCajaDAO{

	public JPADiarioCajaDAO() {
		super(DiarioCaja.class);
		// TODO Auto-generated constructor stub
	}

}
