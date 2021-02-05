package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.socios.CuentaAhorros;

public interface CuentaAhorrosDAO extends GenericDAO<CuentaAhorros, Integer> {

	CuentaAhorros find_numero(String cuenta);
	
	public List<CuentaAhorros> buscarCuentaSOCIO(int socioID);
}
