package ec.edu.ups.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;

public class UsuarioTest {

	private Usuario usuario;
	private Rol rol;
	private Caja caja;
	
	@Before
	public void setUp() throws Exception {
		this.caja = new Caja(1, "Calle Real 1-23", 1000);
		this.usuario = new Usuario(1, "user1", "1234", new Rol(), this.caja);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrearUsuario() {
		this.usuario.setNombre("Ivan");
		this.usuario.setApellido("Ulloa");
		this.usuario.setCedula("9999999999");
		this.usuario.setTelefono("0981818181");
		this.usuario.setDireccion("Calle Prueba 123");
		this.usuario.setEmail("email@gmail.com");
		
		assertEquals("IvanUlloa99999999990981818181Calle Prueba 123email@gmail.com", this.usuario.getNombre()+this.usuario.getApellido()+this.usuario.getCedula()+this.usuario.getTelefono()+this.usuario.getDireccion()+this.usuario.getEmail());
		
	}
	
	@Test
	public void testAsignarRolUsuario() {
		this.rol = new Rol(1, "U");
		this.usuario.setRol(rol);
		assertEquals("U", this.usuario.getRol().getRol());
	}
	
	@Test
	public void testAsignarRolAdministrador() {
		
		this.rol = new Rol(1, "A");
		this.usuario.setRol(rol);
		assertEquals("A", this.usuario.getRol().getRol());
	}

}
