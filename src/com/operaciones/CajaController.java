package com.operaciones;

import java.util.HashSet;
import java.util.Set;

import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;

public class CajaController {
	
	public Caja caja;
	Set<Usuario> listaUsuarios;
	
	private int id=1;
	private String direccion ="Calle Vieja y Eliat Liut";
	private float saldo = 400.50f;

	
	public CajaController() {
		caja = new Caja();
	}
	
	public float  revisarSaldo() {
		caja = new Caja(id, direccion,saldo);
		System.out.println("El saldo de la caja es "+ saldo);
		return caja.getSaldo();		
	}
	
	public boolean agregarUsuario(Usuario user) {
		listaUsuarios = new HashSet<Usuario>();
		caja = new Caja(id, direccion,saldo);
		listaUsuarios.add(user);
		caja.setUsuarios(listaUsuarios);
		System.out.println("Se se agrego a la lista");
		return true;
		
	}
	
}
