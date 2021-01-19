package ec.edu.ups.jpa;

import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.dao.SolicitudCreditoDAO;

public class JPASolicitudCreditoDAO extends JPAGenericDAO<SolicitudCredito, Integer> implements SolicitudCreditoDAO {

	public JPASolicitudCreditoDAO() {
		super(SolicitudCredito.class);
		// TODO Auto-generated constructor stub
	}

}
