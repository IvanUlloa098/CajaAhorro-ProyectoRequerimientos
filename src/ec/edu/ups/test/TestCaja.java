package ec.edu.ups.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;

public class TestCaja {
	private Caja caja; 
	//private CajaController controladorCaja;
	
	private Usuario user; 
	private Rol rol;
	
	@Before
	public void setUp() throws Exception{
		caja = new Caja(1, "Av Americas y Batan", 400.50);
		rol = new Rol (1,"Admin");
		user = new Usuario(1, "dianaTixi", "patito123", rol, new Caja());
	
	}
	// Este metodo esta realizado para revisar el saldo de la Caja
	@Test
	public void obtenerSaldo(){
		double valorPrueba= 400.50;
		double saldo= caja.getSaldo();
		assertEquals("Test Control Saldo Caja", valorPrueba, saldo, 0.01d);
		
	}
	
	//Este metodo esta realizado para asociar un usuario a la caja
	@Test
	public void usuarioAdd() {
		boolean confirmacion= caja.agregarUsuario(user, caja);
		assertTrue("Se Agrego Correctamente", confirmacion);
	}
	
	@After
	public void tearDown() throws Exception {
		
	}

}
