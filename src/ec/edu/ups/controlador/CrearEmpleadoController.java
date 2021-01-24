package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.RolDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Persona;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;

/**
 * Servlet implementation class CrearEmpleadoController
 */
@WebServlet("/CrearEmpleadoController")
public class CrearEmpleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDao;
	private RolDAO rolDao;
	private CajaDAO cajaDao;
	
	private Persona persona;
	private Usuario usuario;
	private Rol rol;
	private Caja caja;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearEmpleadoController() {
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    	cajaDao = DAOFactory.getFactory().getCajaDAO();
    	rolDao= DAOFactory.getFactory().getRolDAO();
    	Usuario usuario;
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		
		try {
			String nombreRol= request.getParameter("rol");
			String idCaja= request.getParameter("caja");
			System.out.println("Rol: "+ nombreRol +" Caja: "+idCaja );
			// Busqueda
			
			rol =rolDao.buscarR(nombreRol);
			System.out.println("Rol es : "+rol.getRol());
			
			int idC = Integer.parseInt(idCaja);
			caja= cajaDao.read(idC);
			
			String user= request.getParameter("username");
			String pass = request.getParameter("password");
			
			usuario = new Usuario(user, pass, rol, caja);
			usuario.setApellido(request.getParameter("apellido"));
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setCedula(request.getParameter("cedula"));
			usuario.setTelefono(request.getParameter("telefono"));
			usuario.setDireccion(request.getParameter("direccion"));
			usuario.setEmail(request.getParameter("email"));
			usuarioDao.create(usuario);
			url= "/admin/indexA.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
