package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.socios.Socio;

public interface SocioDAO extends GenericDAO<Socio, Integer>{
	public Socio buscarCedula(String cedula);
}
