package ec.edu.ups.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.creditos.CarteraCreditos;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.PagoCuotas;
import ec.edu.ups.creditos.TablaAmortizacion;

public class TestCarteraCreditos {
	
	private Credito credito;
	private Set<PagoCuotas> listaPAgoCuotas = new HashSet<PagoCuotas>();
	private Set<TablaAmortizacion> listaTablaAmortizacion = new HashSet<TablaAmortizacion>();
	private boolean confirmacion = false;
	private CarteraCreditos carteraCreditos;
	
	@Before
	public void setUp() throws Exception {
		carteraCreditos = new CarteraCreditos();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAgregarCredito() {
		
		credito = new Credito();
		char h = 1;
		credito.setId(1);
		credito.setMonto(200);
		credito.setInteres(12);
		credito.setNumeroCuota(2);
		credito.setEstado(h);
		credito.setPagos(listaPAgoCuotas);
		credito.setTablaAmortizacion(listaTablaAmortizacion);
		
		confirmacion = carteraCreditos.agregarCredito(credito);
		assertTrue("exito", confirmacion);
	}

}
