package ec.edu.ups.jpa;

import ec.edu.ups.creditos.TablaAmortizacion;
import ec.edu.ups.dao.TablaAmortizacionDAO;

public class JPATablaAmortizacionDAO extends JPAGenericDAO<TablaAmortizacion, Integer> implements TablaAmortizacionDAO {

	public JPATablaAmortizacionDAO() {
		super(TablaAmortizacion.class);
		// TODO Auto-generated constructor stub
	}

}
