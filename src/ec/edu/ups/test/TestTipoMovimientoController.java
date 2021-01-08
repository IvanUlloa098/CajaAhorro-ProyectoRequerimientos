package ec.edu.ups.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.aporte_ahorros.TipoMovimiento;
import ec.edu.ups.controlador.TipoMovimientoController;

public class TestTipoMovimientoController {
	
	private TipoMovimientoController controller;
	private int id =1 ;
	private String nombre = "Juan";
	private boolean suma = true;
	private boolean confirmacion = false;
	private TipoMovimiento tipoMovimiento;
	

	@Before
	public void setUp() throws Exception {
		controller = new TipoMovimientoController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrearTipoMovimiento() {
		
		tipoMovimiento = new TipoMovimiento();
		tipoMovimiento.setId(id);
		tipoMovimiento.setNombre(nombre);
		tipoMovimiento.setSuma(suma);
		
		confirmacion = controller.crearTipoMovimiento(tipoMovimiento);
		
		assertTrue("exito" , confirmacion);
		
	}

}
