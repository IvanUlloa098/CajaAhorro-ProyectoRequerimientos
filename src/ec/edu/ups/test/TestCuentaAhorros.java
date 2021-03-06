package ec.edu.ups.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;
import ec.edu.ups.socios.CuentaAhorros;
import ec.edu.ups.socios.Socio;

public class TestCuentaAhorros {

	private CuentaAhorros cuentaAhorros;
	private Socio socio;
	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		this.socio = new Socio('A');
		this.socio.setNombre("Juan");
		this.socio.setApellido("Paredes");
		this.socio.setCedula("9999999999");
		this.socio.setTelefono("0987878567");
		this.socio.setDireccion("Calle Prueba 456");
		this.socio.setEmail("emailsocio@gmail.com");
		
		this.usuario = new Usuario("user1", "1234", new Rol(), new Caja());
		this.usuario.setNombre("Ivan");
		this.usuario.setApellido("Ulloa");
		this.usuario.setCedula("9999999999");
		this.usuario.setTelefono("0981818181");
		this.usuario.setDireccion("Calle Prueba 123");
		this.usuario.setEmail("email@gmail.com");
	}

	@After
	public void tearDown() throws Exception {
	}

	//El siguiente metodo nos indica la creacion de una cuenta asociada a un socio
	@Test
	public void testCrearCuentadeAhorrosSocio() {
		Date date = new Date();
		//this.cuentaAhorros = new CuentaAhorros(1, 12121212, date, 'A', socio);
		
		assertEquals(socio, cuentaAhorros.getSocio());
	}
	
	//El siguiente metodo crea una cuenta de ahorros asignada a un usuario
	@Test
	public void testCrearCuentadeAhorrosUsuario() {
		Date date = new Date();
		
		this.socio = new Socio('A');
		this.socio.setNombre(usuario.getNombre());
		this.socio.setApellido(usuario.getApellido());
		this.socio.setCedula(usuario.getCedula());
		this.socio.setTelefono(usuario.getTelefono());
		this.socio.setDireccion(usuario.getDireccion());
		this.socio.setEmail(usuario.getEmail());
		
		//this.cuentaAhorros = new CuentaAhorros(1, 12121212, date, 'A', socio);
		assertEquals(socio, cuentaAhorros.getSocio());
	}

}
