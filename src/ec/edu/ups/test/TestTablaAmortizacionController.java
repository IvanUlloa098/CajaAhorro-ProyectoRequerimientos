package ec.edu.ups.test;

import static org.junit.Assert.*;

import java.util.Date;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.controlador.TablaAmortizacionController;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.TablaAmortizacion;

public class TestTablaAmortizacionController {

	private TablaAmortizacionController controller;
	private int id = 1;
	private int numCuota = 120;
	private Date fechaVenc;
	private Date fechaPag;
	private float capital = (float) 123.44;
	private int cuotas = 2;
	private float interes = (float) 2.5;
	private float saldo = (float) 301.03;
	private Credito credito;
	private TablaAmortizacion tablaAmorizacion;
	private boolean confirmacion = false;
	
	
	@Before
	public void setUp() throws Exception {
		controller = new TablaAmortizacionController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testcrearTablaAmortizacion() {
		tablaAmorizacion = new TablaAmortizacion();
		tablaAmorizacion.setId(id);
		tablaAmorizacion.setNumCuota(numCuota);
		tablaAmorizacion.setFechaVenc(fechaVenc);
		tablaAmorizacion.setFechaPag(fechaPag);
		tablaAmorizacion.setCapital(capital);
		tablaAmorizacion.setCuotas(cuotas);
		tablaAmorizacion.setInteres(interes);
		tablaAmorizacion.setSaldo(saldo);
		
		confirmacion = controller.crearTablaAmortizacion(tablaAmorizacion, credito);
		
		assertTrue("exito" , confirmacion);
		
	}

}
