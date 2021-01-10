package ec.edu.ups.test;

import org.junit.Test;

import ec.edu.ups.socios.Socio;
import junit.framework.TestCase;

public class TestSocio extends TestCase {

	private Socio s;
	private Socio se;
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSocio() {
		fail("Not yet implemented");
	}
		
	public void Escenario() {
		s = new Socio(1, 'a');
		
	}
	
	//El metodo verifica que no cree un socio repetido
	@Test
	private void socio() {
		Escenario();
		se = new Socio(1, 'a');
		assertEquals(se, s);
	}

}
