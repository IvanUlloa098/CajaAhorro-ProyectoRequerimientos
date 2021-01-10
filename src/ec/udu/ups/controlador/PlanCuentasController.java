package ec.udu.ups.controlador;

import ec.edu.ups.socios.CuentaAhorros;
import ec.edu.ups.socios.PlanCuentas;

public class PlanCuentasController {

	
	private PlanCuentas plan;
	private int id;
	private String tipo;
	private String descrip;
	
	public PlanCuentasController() {
		plan = new PlanCuentas();
		id = 1;
		tipo = "Tipo";
		descrip = "Descrip";
	}
	
	public boolean agregarPlanCuentas(CuentaAhorros cuentaA) {
		plan.setId(id);
		plan.setTipo(tipo);
		plan.setDescrip(descrip);
		plan.setCuentaA(cuentaA);
		
		return true;
	}
	
}
