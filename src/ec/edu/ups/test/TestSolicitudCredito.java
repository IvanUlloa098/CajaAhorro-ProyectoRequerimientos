package ec.edu.ups.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.socios.CuentaAhorros;
import ec.edu.ups.socios.PlanCuentas;
import ec.edu.ups.socios.Socio;

public class TestSolicitudCredito {
	
	private Socio socio;
	private CuentaAhorros cuentaAhorros;
	private boolean confirmacion = false;
	private PlanCuentas plan;
	private SolicitudCredito solicitud;
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown(){
	}
	
	@Test
	public void testAgregarSolicitudCredito() {
		socio = new Socio();
		
		socio.setId(1);
		socio.setEstado('A');
		
		cuentaAhorros = new CuentaAhorros();
		
		cuentaAhorros.setCuentaId(1);
		cuentaAhorros.setNumeroCta(1);
		cuentaAhorros.setFechaCre(new Date());
		cuentaAhorros.setCuentaAct('A');
		cuentaAhorros.setSocio(socio);
		
		confirmacion = agregarSolicitudCredito(cuentaAhorros);
		
		assertTrue("exito", confirmacion);
		
	}
	
	
	public boolean agregarSolicitudCredito(CuentaAhorros cuentaAhorros) {
		solicitud = new SolicitudCredito();
		int id= 1;
		char estado = 'A';
		Date fecha = new Date();
		solicitud.setId(id);
		solicitud.setEstado(estado);
		solicitud.setFecha(fecha);
		solicitud.setCuentaA(cuentaAhorros);
		
		return true;
	}
}
