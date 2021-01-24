package ec.edu.ups.jpa;

import ec.edu.ups.creditos.CarteraCreditos;
import ec.edu.ups.dao.CarteraCreditosDAO;

public class JPACarteraCreditosDAO extends JPAGenericDAO<CarteraCreditos, Integer> implements CarteraCreditosDAO {

	public JPACarteraCreditosDAO() {
		super(CarteraCreditos.class);
		// TODO Auto-generated constructor stub
	}

}
