package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PlanCuentasDAO;
import ec.edu.ups.socios.PlanCuentas;

/**
 * Servlet implementation class CrearSocioCuentaController
 */
@WebServlet("/CrearSocioCuentaController")
public class CrearSocioCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PlanCuentasDAO planCuentaDao;
	private List<PlanCuentas> listaPlanes;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearSocioCuentaController() {
        super();
        planCuentaDao= DAOFactory.getFactory().getPlanCuentasDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url= null;
		try {
			listaPlanes = planCuentaDao.findAll();
			System.out.println("El tamaño de la lista es: " +listaPlanes.size());
			request.setAttribute("planes", listaPlanes);
			url= "/emp/crearSocioCuenta.jsp";
		} catch (Exception e) {
			e.printStackTrace();
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
