package ec.edu.ups.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.operaciones.CajaController;

import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;

public class TestCaja {
	private Caja caja; 
	
	private CajaController controladorCaja;
	
	private Usuario user; 
	private Rol rol;
	private boolean confirmacion = false;
	
	@Before
	public void setUp() throws Exception{
		controladorCaja = new CajaController();
	
	}
	@Test
	public void obtenerSaldo(){
		double valorPrueba= 400.50f;
		float saldoCaja = controladorCaja.revisarSaldo();
		double saldo= saldoCaja;
		assertEquals("Test suma", valorPrueba, saldo, 1e-6);
		
	}
	@Test
	public void usuarioAdd() {
		rol = new Rol();
		rol.setId(1);
		rol.setRol("Admin");
		user = new Usuario(1, "dianaTixi", "patito123", rol);
		confirmacion = controladorCaja.agregarUsuario(user);
		assertTrue("Add Exitoso", confirmacion);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	

}
