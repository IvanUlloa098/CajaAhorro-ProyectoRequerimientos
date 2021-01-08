package ec.edu.ups.controlador;

import ec.edu.ups.aporte_ahorros.TipoMovimiento;

public class TipoMovimientoController {

	public TipoMovimiento tipoMovimiento;
	
	
	public TipoMovimientoController() {
		tipoMovimiento = new TipoMovimiento();
		
	}
	
	
	public boolean crearTipoMovimiento(TipoMovimiento tipoMov ) {
		
		tipoMovimiento = new TipoMovimiento(tipoMov.getId(), tipoMov.getNombre(), tipoMov.isSuma());
		
		return true;
	};
}
