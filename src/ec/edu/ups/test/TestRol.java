package ec.edu.ups.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;

public class TestRol {
	private Usuario usuario; 
	private Rol rol; 
	
	

	@Before
	public void paraEjecutarAntes()throws Exception{
		usuario = new Usuario();
		
	}
	//El siguiente metodo asigna un rol a un usuario
	@Test
	public void asignarRolAdmin() {
		rol= new Rol(1, "ADMINISTRADOR");
	}
	
	@Test
	public void asignarRolUsuario() {
		rol= new Rol(2, "USUARIO");
	}
	
	@After
	public void paraEjecutarDespues() throws Exception{
		

	}
}
