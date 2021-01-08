package com.operaciones;

import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;

public class RolController {
	
	private Rol rol;
	private Usuario user;
	private Caja caja;

	public boolean asignarRol(String correo) {
		//System.out.println("el correo recibido es: " +correo);
		String correoAux="ups.edu.ec";
		String correoAux2="gmail.com";
		
		if(correo.endsWith(correoAux)) {
			String nombreRol="Admin";
			System.out.println("El rol del usuario es: "+ nombreRol);
			return true;
		}else {
			if(correo.endsWith(correoAux2)) {
				String nombreRol2="User";
				System.out.println("El rol del usuario es: "+ nombreRol2);
				return true;
			}
		}		
		return false;
	}
}
