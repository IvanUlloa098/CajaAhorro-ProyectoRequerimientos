package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.SocioDAO;
import ec.edu.ups.socios.Socio;

/**
 * Servlet implementation class EditarSocioController
 */
@WebServlet("/EditarSocioController")
public class EditarSocioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Socio socio;
	
	private SocioDAO socioDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarSocioController() {
        super();
        socioDao = DAOFactory.getFactory().getSocioDAO();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String cedula = request.getParameter("cedula");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String email = request.getParameter("email");
		
		try {
			
			socio = socioDao.read(Integer.valueOf(id));
			
			socio.setApellido(apellido);
			socio.setNombre(nombre);
			socio.setCedula(cedula);
			socio.setTelefono(telefono);
			socio.setDireccion(direccion);
			socio.setEmail(email);
			socio.setEstado('A');
			
			socioDao.update(socio);
			
			url= "/emp/indexE.jsp";
			
		} catch (Exception e) {
			System.out.println(">>>WARNING (EditarSocioController): " + e.getMessage());
			url= "/CargarTiposController";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
