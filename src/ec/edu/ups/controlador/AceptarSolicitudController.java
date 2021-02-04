package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.creditos.CarteraCreditos;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.dao.CarteraCreditosDAO;
import ec.edu.ups.dao.CreditoDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.SolicitudCreditoDAO;

/**
 * Servlet implementation class AceptarSolicitudController
 */
@WebServlet("/AceptarSolicitudController")
public class AceptarSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SolicitudCredito solicitud;
	private Credito credito;
	private CarteraCreditos cartera; 
	
	private SolicitudCreditoDAO solicitudDAO;
	private CreditoDAO creditoDAO;
	private CarteraCreditosDAO carteraDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AceptarSolicitudController() {
        super();
        solicitudDAO = DAOFactory.getFactory().getSolicitudCreditoDAO();
        creditoDAO = DAOFactory.getFactory().getCreditoDAO();
        carteraDAO = DAOFactory.getFactory().getCarteraCreditosDAO();
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
		Double monto_real;
		Date fecha = new Date();
		int interes;
		
		Optional<String> s = request.getParameterMap().keySet().stream().filter(e->e.contains("modificar_")).findFirst();
		Optional<String> s1 = request.getParameterMap().keySet().stream().filter(e->e.contains("eliminar_")).findFirst();
		
		try {
			if(s.isPresent()) {
				
				solicitud = solicitudDAO.read(Integer.parseInt(s.get().split("_")[1]));
				
				solicitud.setEstado('A');
				
				solicitudDAO.update(solicitud);
				interes=10;
				monto_real = solicitud.getMonto() - (solicitud.getMonto() * 0.1);
				
				cartera = new CarteraCreditos(0, 'A', 0);
				
				credito = new Credito((Double) monto_real, 10, solicitud.getCuotas(), 'A', fecha,  solicitud.getCuentaA(), cartera);
				
				carteraDAO.create(cartera);
				creditoDAO.create(credito);
				
				System.out.println(">>>>>>>>>>>>>  UPDATE RESPONSE FROM /AceptarSolicitudController");
				url= "/admin/indexA.jsp";
			} else {
				
				solicitud = solicitudDAO.read(Integer.parseInt(s1.get().split("_")[1]));
				
				solicitud.setEstado('D');
				
				solicitudDAO.update(solicitud);
				
				System.out.println(">>>>>>>>>>>>>  DELETE RESPONSE FROM /AceptarSolicitudController");
				url= "/admin/indexA.jsp";
			}
		} catch (Exception e2) {
			System.out.println(">>>>>>>>>>>>>  ERROR RESPONSE FROM /AceptarSolicitudController");
			url= "/admin/aprobarCredito.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
