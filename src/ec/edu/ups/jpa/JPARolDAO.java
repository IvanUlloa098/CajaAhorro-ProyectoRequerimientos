package ec.edu.ups.jpa;

import ec.edu.ups.dao.RolDAO;
import ec.edu.ups.gestion.Rol;

public class JPARolDAO extends JPAGenericDAO<Rol, Integer> implements RolDAO {

	public JPARolDAO() {
		super(Rol.class);
		// TODO Auto-generated constructor stub
	}
	
	

}
