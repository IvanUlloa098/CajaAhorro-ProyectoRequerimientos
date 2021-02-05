package ec.edu.ups.dao;

import ec.edu.ups.socios.Socio;

public interface SocioDAO extends GenericDAO<Socio, Integer>{
	
	Socio findCedula(String cedula);
	
}
