package ec.edu.ups.jpa;

import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.gestion.Caja;

public class JPACajaDAO extends JPAGenericDAO<Caja, Integer> implements CajaDAO{

	public JPACajaDAO() {
		super(Caja.class);
		// TODO Auto-generated constructor stub
	}

}
