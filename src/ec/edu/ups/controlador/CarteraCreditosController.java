package ec.edu.ups.controlador;


import ec.edu.ups.creditos.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CarteraCreditosController {
	
	//public List<Credito> listaCredito;
	public CarteraCreditos carteraCredito;
	public Set<Credito> listaCredito;
	
	private int id;
	private char calificacion;
	private int diasMora;
	
	public CarteraCreditosController() {
		
		carteraCredito = new CarteraCreditos();
		listaCredito = new HashSet<Credito>();
		
		id = 1;
		calificacion = 1;
		diasMora = 30;
		 
	}
	
	
	public boolean agregarCredito(Credito credito) {
		carteraCredito = new CarteraCreditos(id, calificacion, diasMora);
		listaCredito.add(credito);
		
		carteraCredito.setCreditos(listaCredito);
	
		
		
		return true;
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
}
