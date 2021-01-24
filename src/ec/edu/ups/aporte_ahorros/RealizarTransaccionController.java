package ec.edu.ups.aporte_ahorros;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DiarioCajaDAO;
import ec.edu.ups.dao.MovimientoDAO;
import ec.edu.ups.gestion.DiarioCaja;

/**
 * Servlet implementation class RealizarTransaccionController
 */
@WebServlet("/RealizarTransaccionController")
public class RealizarTransaccionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Movimiento movimiento;
	private DiarioCaja diario;
	private DiarioCajaDAO diarioDAO;
	private MovimientoDAO movDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizarTransaccionController() {
        super();
        diarioDAO = DAOFactory.getFactory().getDiarioCajaDAO();
        movDAO = DAOFactory.getFactory().getMovimientoDAO();
        
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
		
		try {
			String monto = request.getParameter("monto");
			String cuenta = request.getParameter("cuenta");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		doGet(request, response);
	}

}
