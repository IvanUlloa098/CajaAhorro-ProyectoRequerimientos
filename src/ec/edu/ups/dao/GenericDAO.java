package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.creditos.TablaAmortizacion;

public interface GenericDAO <T, ID>{
	
	public void create(T entity);

	public T read(ID id);

	public void update(T entity);

	public void delete(T entity);

	public void deleteByID(ID id);

	public List<T> findAll();

	public T buscarR(String nombre);

	public T Login(String username, String password);

	public T buscarPlanes(String nombre);

	public T buscarSocio(String cedula);

	public T buscarSolicitud(int id);

	public T buscarCuenta(String numeroC);

	public T Creditos(String numeroC);


	public T Tabla(int nume, int idC);

	public List<TablaAmortizacion> listaT(int idCred);
	
	

}
