package ec.edu.ups.jpa;

import ec.edu.ups.aporte_ahorros.TipoMovimiento;
import ec.edu.ups.dao.TipoMovimientoDAO;

public class JPATipoMovimientoDAO extends JPAGenericDAO<TipoMovimiento, Integer> implements TipoMovimientoDAO {

	public JPATipoMovimientoDAO() {
		super(TipoMovimiento.class);
		// TODO Auto-generated constructor stub
	}

}
