package ec.edu.ups.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.aporte_ahorros.Movimiento;
import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.DiarioCaja;
import ec.udu.ups.controlador.DiarioCajaController;


public class TestDiarioCaja {

	private DiarioCajaController controller;
	private boolean confirmacion = false;
	private Caja caja;
	private HashSet<Movimiento> movimientos;
	private DiarioCaja diario;
	
	@Before
	public void setUp() {
		controller = new DiarioCajaController();
	}
	
	@After
	public void tearDown(){
	}
	
	@Test
	public void testAgregarDiarioCaja() {
		caja = new Caja();
		
		caja.setId(1);
		caja.setDireccion("Cuenca");
		caja.setSaldo((float) 155.36);
		
		movimientos = new HashSet<Movimiento>();
		
		confirmacion = agregarDiarioCaja(caja, movimientos);
		
		
		
		assertTrue("exito", confirmacion);
		
	}
	
	public boolean agregarDiarioCaja(Caja caja, HashSet<Movimiento> movimientos) {
		diario = new DiarioCaja();
		diario.setFecha(new Date());
		diario.setCaja(caja);
		diario.setMovimiento(movimientos);
		
		return true;
	}
}
