package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.TabableView;

import ec.edu.ups.creditos.CarteraCreditos;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.creditos.TablaAmortizacion;
import ec.edu.ups.dao.CarteraCreditosDAO;
import ec.edu.ups.dao.CreditoDAO;
import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.SocioDAO;
import ec.edu.ups.dao.SolicitudCreditoDAO;
import ec.edu.ups.dao.TablaAmortizacionDAO;
import ec.edu.ups.socios.CuentaAhorros;
import ec.edu.ups.socios.Socio;

/**
 * Servlet implementation class BuscarTablaAmortizacion
 */
@WebServlet("/BuscarTablaAmortizacion")
public class BuscarTablaAmortizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SolicitudCredito solicitud;
	private Credito credito;
	private CarteraCreditos cartera; 
	private TablaAmortizacion tabla;
	private Socio socio;
	private List<TablaAmortizacion> listaTabla;
	private CuentaAhorros cuenta ;
	
	private SolicitudCreditoDAO solicitudDAO;
	private CreditoDAO creditoDAO;
	private CarteraCreditosDAO carteraDAO;
	private TablaAmortizacionDAO tablaDAO;
	private SocioDAO socioDAO;
	private CuentaAhorrosDAO cuentaAhorrosDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarTablaAmortizacion() {
        super();
        tablaDAO= DAOFactory.getFactory().getTablaAmortizacionDAO();
        creditoDAO= DAOFactory.getFactory().getCreditoDAO();
        cuentaAhorrosDAO= DAOFactory.getFactory().getCuentaAhorrosDAO();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url=null;
		String numCuenta= request.getParameter("cuenta");
		String cedula1 = request.getParameter("cedula");
		System.out.println("Numero Cuenta es: ");
				try {
					System.out.println("Numero Cuenta es: "+numCuenta);
					
					
					CuentaAhorros cuenta = new CuentaAhorros();
					cuenta = cuentaAhorrosDAO.buscarCuenta(numCuenta);
					int IDCuenta= cuenta.getId();
					
					credito= new Credito();
					credito = creditoDAO.Creditos(numCuenta);
					
					int idCred= credito.getId();
					System.out.println("ID Credito"+ idCred);
					
					String cedulaSocio = credito.getCuentaA().getSocio().getCedula();
					System.out.println("La Cedula del Socio es"+ cedulaSocio);
					
					listaTabla = tablaDAO.listaT(idCred);
					System.out.println("Tamano de la lista: "+ listaTabla.size());
					request.setAttribute("listaTabla", listaTabla);
					url = "/emp/listaAmortizaciones.jsp";
					
				} catch (Exception e) {
					System.out.println("Error Lista Tabla de Amortizacion: " + e);
					//url = "/JSPs/error.jsp";
				}
				getServletContext().getRequestDispatcher(url).forward(request, response);	
				
	}
}
