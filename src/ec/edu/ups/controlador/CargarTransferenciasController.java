package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.aporte_ahorros.TipoMovimiento;
import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.RolDAO;
import ec.edu.ups.dao.TipoMovimientoDAO;
import ec.edu.ups.gestion.Caja;

/**
 * Servlet implementation class CargarTransferenciasController
 */
@WebServlet("/CargarTransferenciasController")
public class CargarTransferenciasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CajaDAO cajaDao;
	private RolDAO rolDao;
	private TipoMovimientoDAO tipoDAO;
	private List<Caja> listaCaja;
	private List<TipoMovimiento> listaTipo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarTransferenciasController() {
    	cajaDao = DAOFactory.getFactory().getCajaDAO();
    	rolDao = DAOFactory.getFactory().getRolDAO();
    	tipoDAO = DAOFactory.getFactory().getTipoMovimientoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url= null;
		try {
			listaCaja = cajaDao.findAll();
			listaTipo = tipoDAO.findAll();
			request.setAttribute("tipos", listaTipo);
			request.setAttribute("cajas", listaCaja);
			url= "/emp/transferencia.jsp";
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
