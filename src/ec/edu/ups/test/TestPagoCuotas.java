package ec.edu.ups.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.creditos.CarteraCreditos;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.PagoCuotas;
import ec.edu.ups.socios.CuentaAhorros;
import ec.edu.ups.socios.Socio;

public class TestPagoCuotas {

	private CuentaAhorros cuentaAhorros;
	private CarteraCreditos carteraCreditos;
	private Socio socio;
	private PagoCuotas pagoCuotas;
	private Credito credito;
	
	@Before
	public void setUp() throws Exception {
		this.socio = new Socio(1, 'A');
		this.socio.setNombre("Juan");
		this.socio.setApellido("Paredes");
		this.socio.setCedula("9999999999");
		this.socio.setTelefono("0987878567");
		this.socio.setDireccion("Calle Prueba 456");
		this.socio.setEmail("emailsocio@gmail.com");
		
		Date date = new Date();
		this.cuentaAhorros = new CuentaAhorros(1, 12121212, date, 'A', socio);
		
		carteraCreditos = new CarteraCreditos(1,'N',0);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPagoNormal() {
		Date date = new Date();
		
		this.credito = new Credito(1, 1800, 15, 6, 'A',cuentaAhorros, carteraCreditos);
		this.pagoCuotas = new PagoCuotas(1,1000, date,this.credito);
		
		float monto = (this.pagoCuotas.getCredito().getMonto()/this.pagoCuotas.getCredito().getNumeroCuota())*(((float)this.pagoCuotas.getCredito().getInteres())/100);
		pagoCuotas = new PagoCuotas(1, 0, date, this.credito);
		if(pagoCuotas.verificarCredito()==true) {
			pagoCuotas.setMontoPag(monto);
		}
		
		assertEquals((float) 1755, (float) (this.credito.getMonto()-this.pagoCuotas.getMontoPag()), 0.01d);
	}
	
	@Test
	public void testPagoAtipico() {
		//Pagar menos de la cuota
		Date date = new Date();
		
		this.credito = new Credito(2, 2000, 15, 6, 'A',cuentaAhorros, carteraCreditos);
		this.pagoCuotas = new PagoCuotas(1,1000, date,this.credito);
		
		float monto = 100 * (((float)this.pagoCuotas.getCredito().getInteres())/100);
		
		pagoCuotas = new PagoCuotas(2, 0, date, this.credito);
		if(pagoCuotas.verificarCredito()==true) {
			this.pagoCuotas.setMontoPag(monto);
		} else {
			this.pagoCuotas = new PagoCuotas();
		}
		
		assertEquals((float) 1985, (float) (this.credito.getMonto()-this.pagoCuotas.getMontoPag()), 0.01d);
		
	}
	
	@Test
	public void testPagoSinDeuda() {
		
		Date date = new Date();
		
		this.credito = new Credito(3, 10, 15, 6, 'D',cuentaAhorros, carteraCreditos);
		this.pagoCuotas = new PagoCuotas(1,1000, date,this.credito);
		
		float monto = 100 * (((float)this.pagoCuotas.getCredito().getInteres())/100);
		
		
		pagoCuotas = new PagoCuotas(3, 0, date, this.credito);
		if(pagoCuotas.verificarCredito()==true) {
			this.pagoCuotas.setMontoPag(monto);
		} else {
			this.pagoCuotas = new PagoCuotas();
		}
		
		assertEquals((float) 0, (float) this.pagoCuotas.getMontoPag(), 0.01d);
		
	}

}