package ec.edu.ups.jpa;

import ec.edu.ups.aporte_ahorros.Movimiento;
import ec.edu.ups.dao.MovimientoDAO;

public class JPAMovimientoDAO extends JPAGenericDAO<Movimiento, Integer> implements MovimientoDAO {

	public JPAMovimientoDAO() {
		super(Movimiento.class);
		// TODO Auto-generated constructor stub
	}

}
