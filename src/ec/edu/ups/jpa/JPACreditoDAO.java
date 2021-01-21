package ec.edu.ups.jpa;

import ec.edu.ups.creditos.Credito;
import ec.edu.ups.dao.CreditoDAO;

public class JPACreditoDAO extends JPAGenericDAO<Credito, Integer> implements CreditoDAO {

	public JPACreditoDAO() {
		super(Credito.class);
		// TODO Auto-generated constructor stub
	}
	
}
