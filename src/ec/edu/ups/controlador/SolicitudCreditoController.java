package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.SolicitudCreditoDAO;
import ec.edu.ups.socios.CuentaAhorros;

/**
 * Servlet implementation class SolicitudCreditoController
 */
@WebServlet("/SolicitudCreditoController")
public class SolicitudCreditoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private CuentaAhorros ca;
	private SolicitudCredito solicitud;
	
	private CuentaAhorrosDAO cuentaDAO;
	private SolicitudCreditoDAO solicitudDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitudCreditoController() {
        super();
        cuentaDAO = DAOFactory.getFactory().getCuentaAhorrosDAO();
        solicitudDAO = DAOFactory.getFactory().getSolicitudCreditoDAO();
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
		Date date = new Date();
		
		try {
			
			HttpSession  session=request.getSession(true);
			
			String monto = request.getParameter("monto");
			String cuenta = request.getParameter("cuenta");
			String cedula = request.getParameter("cedula");
			String descripcion = request.getParameter("descripcion");
			String cuotas = request.getParameter("cuotas");
			
			ca = cuentaDAO.find_numero(cuenta);
			
			solicitud = new SolicitudCredito('E', date, Double.valueOf(monto), descripcion, ca, Integer.valueOf(cuotas));
			
			solicitudDAO.create(solicitud);
			
			solicitud = new SolicitudCredito();
			System.out.println(">>>>>> SOLICITUD EN ESPERA");
			url= "/emp/indexE.jsp";
			
		} catch (Exception e) {
			url= "/emp/solicitarCredito.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
