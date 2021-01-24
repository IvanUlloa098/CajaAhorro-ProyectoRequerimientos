package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.RolDAO;
import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;

/**
 * Servlet implementation class CrearEmpladoController2
 */
@WebServlet("/CrearEmpladoController2")
public class CrearEmpladoController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CajaDAO cajaDao;
	private RolDAO rolDao;
	
	private List<Caja> listaCaja;
	private List<Rol> listaRol;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearEmpladoController2() {
    	cajaDao= DAOFactory.getFactory().getCajaDAO();
    	rolDao= DAOFactory.getFactory().getRolDAO();
       }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url= null;
		try {
			listaCaja = cajaDao.findAll();
			System.out.println("EL tamaño de la lista es: "+listaCaja.size());
			listaRol = rolDao.findAll();
			System.out.println("El tamaño de la lista es:"+ listaRol.size());
			request.setAttribute("roles", listaRol);
			request.setAttribute("cajas", listaCaja);
			url= "/admin/crearEmpleados.jsp";
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
