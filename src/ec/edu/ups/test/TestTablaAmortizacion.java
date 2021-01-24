package ec.edu.ups.test;

import static org.junit.Assert.*;

import java.util.Date;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.TablaAmortizacion;

public class TestTablaAmortizacion {

	private Credito credito;
	private TablaAmortizacion tablaAmorizacion;
	private boolean confirmacion = false;
	private  Date fecha = new Date();
	
	
	@Before
	public void setUp() throws Exception {
		this.tablaAmorizacion = new TablaAmortizacion(1, 3, fecha, 5, 0.0, 0.0, 0.0, 6000.00, "pendiente", credito);
	}

	@After
	public void tearDown() throws Exception {
	}

	//El siguiente metodo calcula el capital de un credito 
	@Test
	public void testCalculaCapital() {
		this.tablaAmorizacion.setPagoTotal(2203.25);
		this.tablaAmorizacion.setInteres(300);
		
		double capitalEsperado = 1903.25;
		double capitalObtenido=(tablaAmorizacion.calculaCapital());
		assertEquals(capitalEsperado , capitalObtenido , 1e-2);
		
	}
	
	//El siguiente metodo calcula el interes que genera el prestamo
	@Test
	public void testCalculaInteres() {
		//this.tablaAmorizacion.setSaldo(6000.00);
		
		double interesEsperado = 300;
		double interesObtenido=(tablaAmorizacion.calculaInteres());
		assertEquals(interesEsperado , interesObtenido , 1e-2);
		
	}
	
	//El siguiente metodo calcula el valor total de una cuota a pagar
	@Test
	public void testCalculaPagoTotal() {
		double pagoTotalEsperado = 2203.25;
		double pagoTotalObtenido=(tablaAmorizacion.calculaPagoTotal());
		assertEquals(pagoTotalEsperado , pagoTotalObtenido , 1e-2);
		
	}
	
	//El metodo a continuacion calcula el monto total que adeuda el socio
	@Test
	public void testCalculaSaldo() {
		this.tablaAmorizacion.setCapital(1903.25);
		
		double saldoEsperado = 4096.75;
		double saldoObtenido=(tablaAmorizacion.calculaSaldo());
		assertEquals(saldoEsperado , saldoObtenido , 1e-2);
		
	}
	
	// El metodo a continuacion simula el pago de un cuota en especifico 
	@Test
	public void testCalculaPagoUnaCuota() {
		int cuota = 3;
		//double saldoCuotaEsperado2 = 2098.34;
		double saldoCuotaEsperado1 = 0;
		
		double saldoCuotaObtenido=(tablaAmorizacion.calculaPagoUnaCuota(cuota));
		
		assertEquals(saldoCuotaEsperado1 , saldoCuotaObtenido , 1e-2);
		
	}
	

}
