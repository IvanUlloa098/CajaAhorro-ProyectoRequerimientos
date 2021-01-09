package ec.edu.ups.test;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.aporte_ahorros.*;
import ec.edu.ups.gestion.*;
import ec.edu.ups.socios.*;


public class TestMovimiento {

	private CuentaAhorros ca;
	private Movimiento m;
	private Movimiento me;
	private TipoMovimiento tm;
	private TipoMovimiento tme;
	private Date d = new Date(121,0,8);
	
	
	public void escenario()
	{
		tm =new TipoMovimiento();
		tm.setId(1);
		tm.setNombre("Retiro");
		m = new Movimiento(1,d, 400, tm);
	}
			
	@Test
	public void testMovimientos(){
		
		// esperado
		tme = new TipoMovimiento();
		tme.setId(1);
		tme.setNombre("Retiro");
		
		me = new Movimiento(1,d, 400, tme);
		
		escenario();
		assertEquals(me, m);
	
	
}
 


}