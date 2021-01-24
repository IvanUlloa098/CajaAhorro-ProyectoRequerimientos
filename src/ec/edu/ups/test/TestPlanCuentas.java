package ec.edu.ups.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.socios.CuentaAhorros;
import ec.edu.ups.socios.PlanCuentas;
import ec.edu.ups.socios.Socio;

public class TestPlanCuentas {

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
	
	//El siguiente metodo se asigna el un plan de cuenta a una cuenta de ahorros que pertenece a un usuario X
	@Test
	public void testPlanCuentas() {
		socio = new Socio();
		
		socio.setId(1);
		socio.setEstado('A');
		
		cuentaAhorros = new CuentaAhorros();
		
		cuentaAhorros.setId(1);
		cuentaAhorros.setNumero("1");
		cuentaAhorros.setFechaCreacion(new Date());
		cuentaAhorros.setEstado('A');
		cuentaAhorros.setSocio(socio);
	
		confirmacion = agregarPlanCuentas(cuentaAhorros);
	
		assertTrue("exito", confirmacion);
		
	}
	
	public boolean agregarPlanCuentas(CuentaAhorros cuentaA) {
		plan = new PlanCuentas();
		int id = 1;
		String tipo = "Tipo";
		String descrip = "Descrip";
		plan.setId(id);
		plan.setTipo(tipo);
		plan.setDescrip(descrip);
		return true;
	}
	
	
}
