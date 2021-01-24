package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.gestion.Caja;

/**
 * Servlet implementation class CajaController
 */
@WebServlet("/CajaController")
public class CajaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CajaDAO cajaDao;
	private Caja caja;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CajaController() {
        cajaDao= DAOFactory.getFactory().getCajaDAO();
        caja = new Caja();
        // TODO Auto-generated constructor stub
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
		int id = 0;
		try {
			caja.setId(id);
			caja.setDireccion(request.getParameter("direccion"));
			caja.setSaldo(Double.parseDouble(request.getParameter("saldo")));
			cajaDao.create(caja);
			
			url= "/admin/indexA.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
