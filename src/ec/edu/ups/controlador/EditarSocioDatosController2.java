package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.gestion.Usuario;

/**
 * Servlet implementation class retorno
 */
@WebServlet("/EditarSocioDatosController2")
public class EditarSocioDatosController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private Usuario usuario;
	private UsuarioDAO usuariodao;
	
    public EditarSocioDatosController2() {
    	
    	usuariodao = DAOFactory.getFactory().getUsuarioDAO();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url= "/admin/indexA.jsp";
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String url=null;
		System.out.println("ver CEDULAAAAAAAAAAAA ::" + cedula);
		System.out.println("ver NOMBREEEE ::" + nombre);
		
		usuario = usuariodao.buscarCedulaEmpledado(cedula);
		
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		usuario.setDireccion(direccion);
		usuario.setTelefono(telefono);
		usuario.setUsername(username);
		usuario.setPassword(password);
		
		//usuariodao.update(usuario2);
		usuariodao.update(usuario);
		
		url= "/admin/indexA.jsp";
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
