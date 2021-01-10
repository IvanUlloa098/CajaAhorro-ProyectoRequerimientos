package ec.udu.ups.controlador;

import java.util.Date;

import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.socios.CuentaAhorros;

public class SolicitudCreditosController {

	private SolicitudCredito solicitud;
	
	private int id;
	private char estado;
	private Date fecha;
	
	public SolicitudCreditosController() {
		solicitud = new SolicitudCredito();
		id= 1;
		estado = 'A';
		fecha = new Date();
	}
	

}
