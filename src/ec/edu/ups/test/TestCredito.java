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
		ca = new CuentaAhorros(1, 23456789, d, 'a', s,200.30);
		cc = new CarteraCreditos(1,'a',2);
		
		c = new Credito(1, 238.33f, 15, 1, 'B', ca, cc);
		
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
		
	
	@Test
	public void testCredito() {
		//fail("Not yet implemented");
		Escenario();
		ce= new Credito(1,238.33f, 15, 1, 'B', ca, cc);
	//	System.out.println("CE: "+ce);
		//System.out.println("C: "+c);
		
		assertEquals(c, ce);
		
	}
	
	

}
