package ec.edu.ups.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.socios.CuentaAhorros;

public class JPACuentaAhorrosDAO extends JPAGenericDAO<CuentaAhorros, Integer> implements CuentaAhorrosDAO {

	public JPACuentaAhorrosDAO() {
		super(CuentaAhorros.class);
		// TODO Auto-generated constructor stub
	}
	
	public CuentaAhorros find_numero(String cuenta) {
		try {
			String jpql = "SELECT c FROM CuentaAhorros c WHERE c.numero = '"+ cuenta + "'";
			CuentaAhorros ca = null;
			ca = em.createQuery(jpql, CuentaAhorros.class).getSingleResult();
			
			return ca;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	public List<CuentaAhorros> buscarCuentaSOCIO(int socioID) {
		String jpql = "SELECT c FROM CuentaAhorros c WHERE c.estado != 'I' AND c.socio.id=" + socioID ;
		List<CuentaAhorros> cuentasA = (List<CuentaAhorros>) em.createQuery(jpql).getResultList();
		return cuentasA;
	}

}

