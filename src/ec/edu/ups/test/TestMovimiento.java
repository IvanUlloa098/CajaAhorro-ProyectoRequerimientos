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
	
	
	@Test
	public void testDeposito(){
		
		double inicial = 399.33;
		String tipoTXN = "Depo";
		String esperado=ca.Transacciones(inicial, tipoTXN);
		System.out.println(esperado);
		assertEquals(tipoTXN, esperado);
		
	}


	private void assertEquals(String string, String esperado) {
		// TODO Auto-generated method stub
		
	}

	
}
 


