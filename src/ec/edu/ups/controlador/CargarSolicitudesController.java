package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.SolicitudCreditoDAO;

/**
 * Servlet implementation class CargarSolicitudesController
 */
@WebServlet("/CargarSolicitudesController")
public class CargarSolicitudesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private List<SolicitudCredito> solicitudes;
	
	private SolicitudCreditoDAO solicitudDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarSolicitudesController() {
        super();
        solicitudDAO = DAOFactory.getFactory().getSolicitudCreditoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url= null;
		System.out.println(">>>>>> CARGANDO SOLICITUDES");
		try {
			
			solicitudes = solicitudDAO.findAll();
			
			request.setAttribute("solicitudes", solicitudes);
			
			url= "/admin/aprobarCredito.jsp";
			
		} catch (Exception e) {
			url= "/admin/indexA.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
