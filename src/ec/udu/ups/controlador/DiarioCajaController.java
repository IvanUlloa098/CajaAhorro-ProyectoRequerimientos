package ec.udu.ups.controlador;

import java.util.Date;
import java.util.HashSet;

import ec.edu.ups.aporte_ahorros.Movimiento;
import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.DiarioCaja;

public class DiarioCajaController {

	private DiarioCaja diario;
	private Date fecha;
	
	public DiarioCajaController() {
		diario = new DiarioCaja();
		fecha = new Date();
	}
	
	public boolean agregarDiarioCaja(Caja caja, HashSet<Movimiento> movimientos) {
		
		diario.setFecha(fecha);
		diario.setCaja(caja);
		diario.setMovimiento(movimientos);
		
		return true;
	}
}
