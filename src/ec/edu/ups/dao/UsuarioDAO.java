package ec.edu.ups.dao;

import ec.edu.ups.gestion.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {
	public Usuario buscarCedulaEmpledado(String cedula);
}
