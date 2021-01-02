package ec.edu.ups.jpa;

import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.DAOFactory;

public class JPADAOFactory extends DAOFactory {

	@Override
	public CajaDAO getCajaDAO() {
		// TODO Auto-generated method stub
		return new JPACajaDAO();
	}

}
