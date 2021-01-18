package ec.edu.ups.controlador;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.RolDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;

public class Test {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = Persistence.createEntityManagerFactory("CajaAhorro-ProyectoRequerimientos").createEntityManager();	
		RolDAO rolDAO;
		CajaDAO cajaDao;
		UsuarioDAO usuarioDAO;
		Rol rol1, rol2;
		Caja caja;
		Usuario usuario;			
		
		//Creacion de dos roles para administrador y usuario corriente
		rolDAO = DAOFactory.getFactory().getRolDAO();
		rol1 = new Rol(1, "USUARIO");
		rolDAO.create(rol1);
		rol2 = new Rol(2, "ADMINISTRADOR");
		rolDAO.create(rol2);
		
		//Creacion de una caja
		cajaDao = DAOFactory.getFactory().getCajaDAO();
		caja= new Caja(0,"Calle Vieja y Elia Liu",400.50);
		cajaDao.create(caja);
		
		//Creacion de dos usuarios
		usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		usuario = new Usuario("usuario1", "1234", rol1, caja);
		usuario.setNombre("Ivan");
		usuario.setApellido("Ulloa");
		usuario.setCedula("9999999999");
		usuario.setTelefono("0000000000");
		usuario.setDireccion("Av calle");
		usuario.setEmail("mail@mail.com");
		usuarioDAO.create(usuario);
		
		
	}

}
