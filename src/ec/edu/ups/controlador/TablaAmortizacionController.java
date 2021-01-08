package ec.edu.ups.controlador;

import java.util.Date;

import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.TablaAmortizacion;

public class TablaAmortizacionController {

	public TablaAmortizacion tablaAmortizacion;
	
	public TablaAmortizacionController() {
		tablaAmortizacion = new TablaAmortizacion();
	}
	
	

	public boolean crearTablaAmortizacion(TablaAmortizacion tablaAmort, Credito credito ) {
		
		tablaAmortizacion = new TablaAmortizacion(tablaAmort.getId(), tablaAmort.getNumCuota(), tablaAmort.getFechaVenc(), tablaAmort.getFechaPag(), 
				tablaAmort.getCapital(), tablaAmort.getCuotas(), tablaAmort.getInteres(), tablaAmort.getSaldo(), credito);
		
		return true;
	};
}
