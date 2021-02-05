package ec.edu.ups.jpa;

import ec.edu.ups.creditos.Credito;
import ec.edu.ups.dao.CreditoDAO;
import ec.edu.ups.socios.CuentaAhorros;

public class JPACreditoDAO extends JPAGenericDAO<Credito, Integer> implements CreditoDAO {

	public JPACreditoDAO() {
		super(Credito.class);
		
	}
	
	public Credito creditoCedula(String cuenta) {
		
		String jpql = "Select credt FROM Credito credt WHERE credt.cuentaA.numero='" + cuenta+"' AND credt.estado='A'";
		Credito c = null;
		c = em.createQuery(jpql, Credito.class).getSingleResult();
		return c;
		
	}
	
}
