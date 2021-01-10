package ec.edu.ups.test;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.aporte_ahorros.*;
import ec.edu.ups.gestion.*;
import ec.edu.ups.socios.*;


public class TestMovimiento {

	private CuentaAhorros ca;
	private Movimiento m;
	private Socio s;
	private TipoMovimiento tm;
	private double procesado;
	private Date d = new Date(121,0,8);
	
	

	@Before
	public void setUp() throws Exception {
		ca = new CuentaAhorros();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testTransaccion(){
		double inicial = 399.33;
		tm = new TipoMovimiento(1, "retiro", true);
		m= new Movimiento(1, d, inicial, tm);
		s= new Socio(1,'A');
		
			if((tm.getNombre() == "Deposito")) {
				procesado = ca.addDeposito(m.getMonto());
			}else {
				procesado = ca.addRetiro(m.getMonto());
			}
		
			System.out.println(inicial);
			System.out.println(procesado);
		Assert.assertEquals(inicial, procesado, 0);
		

		

		
		
		
	}

	
}
 


