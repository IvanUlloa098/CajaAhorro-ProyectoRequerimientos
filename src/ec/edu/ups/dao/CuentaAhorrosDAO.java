package ec.edu.ups.dao;

import ec.edu.ups.socios.CuentaAhorros;

public interface CuentaAhorrosDAO extends GenericDAO<CuentaAhorros, Integer> {

	CuentaAhorros find_numero(String cuenta);
	
}
