package ec.edu.ups.jpa;

import ec.edu.ups.dao.PlanCuentasDAO;
import ec.edu.ups.socios.PlanCuentas;

public class JPAPlanCuentasDAO extends JPAGenericDAO<PlanCuentas, Integer> implements PlanCuentasDAO{

	public JPAPlanCuentasDAO() {
		super(PlanCuentas.class);
		// TODO Auto-generated constructor stub
	}

}
