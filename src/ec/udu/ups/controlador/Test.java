package ec.udu.ups.controlador;

import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.gestion.Caja;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CajaDAO cajaDao = DAOFactory.getFactory().getCajaDAO();
		Caja caja= new Caja(0,"Calle Vieja y Elia Liu",400);
		cajaDao.create(caja);

	}

}
