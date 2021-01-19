package ec.edu.ups.jpa;

import ec.edu.ups.dao.SocioDAO;
import ec.edu.ups.socios.Socio;

public class JPASocioDAO  extends JPAGenericDAO<Socio, Integer> implements SocioDAO {

	public JPASocioDAO() {
		super(Socio.class);
		// TODO Auto-generated constructor stub
	}

}
