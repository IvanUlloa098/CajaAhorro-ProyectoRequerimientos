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
 * Servlet implementation class CargarDatosSocioController
 */
@WebServlet("/CargarDatosSocioController")
public class CargarDatosSocioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SocioDAO socioDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarDatosSocioController() {
        super();
        socioDAO = DAOFactory.getFactory().getSocioDAO();
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
		
		String url= null;
		String cedula = request.getParameter("cedula");
		Socio socio;
		
		try {
			
			socio = socioDAO.findCedula(cedula);
			
			request.setAttribute("socio", socio);
			
			url= "/emp/editarSocio.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			url= "/emp/indexE.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
