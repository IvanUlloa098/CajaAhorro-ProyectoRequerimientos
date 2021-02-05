package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.SocioDAO;
import ec.edu.ups.socios.CuentaAhorros;
import ec.edu.ups.socios.Socio;

/**
 * Servlet implementation class EliminarSocioCuentaController
 */
@WebServlet("/EliminarSocioCuentaController")
public class EliminarSocioCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SocioDAO sociodao;
	private Socio socio;
	
	private CuentaAhorrosDAO cuentadao;
	private CuentaAhorros cuentaahorros;
	
	private List<CuentaAhorros> listaCuentas;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarSocioCuentaController() {
        super();
        sociodao = DAOFactory.getFactory().getSocioDAO();
        cuentadao = DAOFactory.getFactory().getCuentaAhorrosDAO();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		String cedula = request.getParameter("cedula");
		
		String url= null;
		try {
			socio = sociodao.buscarSocio(cedula);
			char p = 'I';
			listaCuentas = cuentadao.buscarCuentaSOCIO(socio.getId());
			
			System.out.println("tamaño lista Cuenta  :" + listaCuentas.size()) ;
			
			//request.setAttribute("planes", listaCuentas);
			url= "/emp/indexE.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
				String cedula = request.getParameter("cedula");
				
				String url= null;
				try {
					socio = sociodao.buscarSocio(cedula);
					
					listaCuentas = cuentadao.buscarCuentaSOCIO(socio.getId());
					
					System.out.println("tamaño lista Cuenta  :" + listaCuentas.size()) ;
					
					request.setAttribute("cuentas", listaCuentas);
					request.setAttribute("cedula", cedula);
					url= "/emp/EliminarSocioCuenta2.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			}

}
