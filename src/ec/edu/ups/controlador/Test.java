package ec.edu.ups.controlador;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = Persistence.createEntityManagerFactory("CajaAhorro-ProyectoRequerimientos").createEntityManager();
		
		Rol rol = DAOFactory.getFactory().getRolDAO();
		
		CajaDAO cajaDao = DAOFactory.getFactory().getCajaDAO();
		Caja caja= new Caja(0,"Calle Vieja y Elia Liu",400.50);
		cajaDao.create(caja);

	}

}
