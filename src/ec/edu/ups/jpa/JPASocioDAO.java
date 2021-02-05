package ec.edu.ups.jpa;

import ec.edu.ups.dao.SocioDAO;
import ec.edu.ups.socios.Socio;

public class JPASocioDAO  extends JPAGenericDAO<Socio, Integer> implements SocioDAO {

	public JPASocioDAO() {
		super(Socio.class);
		// TODO Auto-generated constructor stub
	}
	
	
	public Socio buscarCedula(String cedula) {
		try {
			String jpql = "SELECT s FROM Socio s WHERE s.cedula = '"+ cedula + "'";
			Socio so = null;
			so = em.createQuery(jpql, Socio.class).getSingleResult();
			
			return so;
			
		} catch (Exception e) {
			return null;
		}
		
	}

}
