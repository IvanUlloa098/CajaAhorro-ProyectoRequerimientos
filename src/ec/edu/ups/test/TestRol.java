package ec.edu.ups.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.operaciones.RolController;

public class TestRol {
	private RolController rolController;
	
	@Test
	public void resultado() {
		String correo = "dtixi@gmail.com";
		assertTrue(rolController.asignarRol(correo));
	}

	@Before
	public void paraEjecutarAntes()throws Exception{
		rolController = new RolController();
	}
	
	@After
	public void paraEjecutarDespues() throws Exception{
		

	}
}
