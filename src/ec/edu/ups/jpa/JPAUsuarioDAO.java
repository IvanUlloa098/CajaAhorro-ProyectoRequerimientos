package ec.edu.ups.jpa;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.gestion.Usuario;
import ec.edu.ups.socios.Socio;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO {

	public JPAUsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}
	
	public Usuario buscarCedulaEmpledado(String cedula) {
		try {
			String jpql = "SELECT u FROM Usuario u WHERE u.rol.rol != 'ADMINISTRADOR' AND u.cedula = '"+ cedula + "'";
			Usuario usu = null;
			usu = em.createQuery(jpql, Usuario.class).getSingleResult();
			
			return usu;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
