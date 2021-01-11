package ec.edu.ups.jpa;

import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.RolDAO;
import ec.edu.ups.dao.UsuarioDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public CajaDAO getCajaDAO() {
		// TODO Auto-generated method stub
		return new JPACajaDAO();
	}

	@Override
	public RolDAO getRolDAO() {
		// TODO Auto-generated method stub
		return new JPARolDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuarioDAO();
	}

}
