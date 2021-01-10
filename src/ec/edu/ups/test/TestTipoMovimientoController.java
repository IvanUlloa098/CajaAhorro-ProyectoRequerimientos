package ec.edu.ups.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.aporte_ahorros.TipoMovimiento;

public class TestTipoMovimientoController {
	
	private boolean confirmacion = false;
	private TipoMovimiento tipoMovimiento;
	

	@Before
	public void setUp() throws Exception {
		tipoMovimiento = new TipoMovimiento();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrearTipoMovimiento() {
		
		confirmacion = tipoMovimiento.crearTipoMovimiento(1, "transferencia", true);
		
		assertTrue("exito" , confirmacion);
		
	}

}
