package ec.edu.ups.jpa;

import ec.edu.ups.creditos.PagoCuotas;
import ec.edu.ups.dao.PagoCuotasDAO;

public class JPAPagoCuotasDAO extends JPAGenericDAO<PagoCuotas, Integer> implements PagoCuotasDAO {

	public JPAPagoCuotasDAO() {
		super(PagoCuotas.class);
		// TODO Auto-generated constructor stub
	}

}
