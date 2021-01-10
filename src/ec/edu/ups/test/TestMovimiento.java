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
	public void testTransaccion(){
		
		double inicial = 399.33;
		String tipoTXN = "Depoto";
		Boolean resultado = ca.Transacciones(inicial, tipoTXN);
		System.out.println("Esperado-> "+tipoTXN);
		System.out.println("Resultado-> "+resultado);
		assertTrue(tipoTXN, resultado);
		
	}
	
	@Test
	public void testTransaccion1(){
		
		double inicial = 399.33;
		String tipoTXN = "Retiro";
		Boolean resultado = ca.Transacciones(inicial, tipoTXN);
		System.out.println("Esperado-> "+tipoTXN);
		System.out.println("Resultado-> "+resultado);
		assertTrue(tipoTXN, resultado);
		
	}

	@Test
	public void testTransaccion2(){
		
		double inicial = 399.33;
		String tipoTXN = "Transferencia";
		Boolean resultado = ca.Transacciones(inicial, tipoTXN);
		System.out.println("Esperado-> "+tipoTXN);
		System.out.println("Resultado-> "+resultado);
		assertTrue(tipoTXN, resultado);
		
	}
	

	
}
 


