package ec.edu.ups.jpa;

import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.socios.CuentaAhorros;

public class JPACuentaAhorrosDAO extends JPAGenericDAO<CuentaAhorros, Integer> implements CuentaAhorrosDAO {

	public JPACuentaAhorrosDAO() {
		super(CuentaAhorros.class);
		// TODO Auto-generated constructor stub
	}
	
	public CuentaAhorros find_numero(String cuenta) {
		
		String jpql = "SELECT c FROM CuentaAhorros c WHERE c.numero = "+cuenta;
		CuentaAhorros ca = null;
		ca = em.createQuery(jpql, CuentaAhorros.class).getSingleResult();
		
		return ca;
	}

}
