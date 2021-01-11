package ec.edu.ups.test;

import java.util.Date;

import org.junit.Test;

import ec.edu.ups.creditos.CarteraCreditos;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.socios.CuentaAhorros;
import ec.edu.ups.socios.Socio;
import junit.framework.TestCase;

public class TestCredito extends TestCase {
	private CarteraCreditos cc;
	private Socio s;
	private Credito c,ce;
	private CuentaAhorros ca;
	private Date d = new Date(121,0,8);

	public void Escenario() {
		s = new Socio();
		s.setId(1);
		s.setEstado('A');
		ca = new CuentaAhorros(1, 23456789, d, 'a', s);
		cc = new CarteraCreditos(1,'a',2);
		
		c = new Credito(1, 238.33, 15, 1, 'B', ca, cc);
		
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	//Este metodo esta realizado para obtener el monto de una cuota de un credito
	@Test
	public void testCalculoCuota() {
		double esperado = 532.381;		
		ce= new Credito(1,238.33, 15, 1, 'B', ca, cc);
		double resultado = ce.calcularCuota(12.4, 12, 6000);
		assertEquals(esperado, resultado, 1e-2);
		
	}
	
	//Este metodo esta realizado para obtener el monto de una cuota de un credito
	//Con la diferencia que este metodo fallara
	@Test
	public void testCalculoCuota1() {
		double esperado = 250.00;		
		ce= new Credito(1,238.33f, 15, 1, 'B', ca, cc);
		double resultado = ce.calcularCuota(15, 24, 6000);
		assertEquals(esperado, resultado, 1e-2);
		
	}

}
