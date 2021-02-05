package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.aporte_ahorros.Movimiento;
import ec.edu.ups.aporte_ahorros.TipoMovimiento;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.PagoCuotas;
import ec.edu.ups.creditos.TablaAmortizacion;
import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.CreditoDAO;
import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DiarioCajaDAO;
import ec.edu.ups.dao.MovimientoDAO;
import ec.edu.ups.dao.PagoCuotasDAO;
import ec.edu.ups.dao.TablaAmortizacionDAO;
import ec.edu.ups.dao.TipoMovimientoDAO;
import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.DiarioCaja;
import ec.edu.ups.socios.CuentaAhorros;

/**
 * Servlet implementation class PagoCuotasController
 */
@WebServlet("/PagoCuotasController")
public class PagoCuotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Movimiento movimiento;
	private DiarioCaja diario;
	private TipoMovimiento tipo;
	private CuentaAhorros ca;
	private Caja caja;
	
	private DiarioCajaDAO diarioDAO;
	private MovimientoDAO movDAO;
	private TipoMovimientoDAO tipoDAO;
	private CuentaAhorrosDAO cuentaDAO;
	private CajaDAO cajaDao;
	private PagoCuotasDAO pagoDAO;
	private TablaAmortizacionDAO tablaDAO;
	private CreditoDAO creditoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagoCuotasController() {
        super();
        // TODO Auto-generated constructor stub
        diarioDAO = DAOFactory.getFactory().getDiarioCajaDAO();
        movDAO = DAOFactory.getFactory().getMovimientoDAO();
        tipoDAO = DAOFactory.getFactory().getTipoMovimientoDAO();
        cuentaDAO = DAOFactory.getFactory().getCuentaAhorrosDAO();
        cajaDao= DAOFactory.getFactory().getCajaDAO();
        pagoDAO = DAOFactory.getFactory().getPagoCuotasDAO();
        tablaDAO = DAOFactory.getFactory().getTablaAmortizacionDAO();
        creditoDAO= DAOFactory.getFactory().getCreditoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String url = null;
		Date date = new Date(); 
		
		try {
			HttpSession  session=request.getSession(true);
			
			String monto = request.getParameter("monto");
			String cuenta = request.getParameter("cuenta");
			String cuota = request.getParameter("cuota");
			System.out.println("|"+monto+"|"+cuenta+"|"+cuota);
			
			Credito credito = new Credito();
			credito = creditoDAO.Creditos(cuenta);
			System.out.println("Credito ID" +credito.getId());
			
			//Agregar a la tabla pagocuota
			PagoCuotas pago = new PagoCuotas();
			pago .setId(0);
			pago.setMontoPag(Double.parseDouble(monto));
			pago.setFecha(new Date());
			pago.setCredito(credito);
			
			pagoDAO.create(pago);
			
			
			//Moficamos el estado y saldo
			Credito credt= new Credito();
			credt = creditoDAO.Creditos(cuenta); 
		
			int idCred=credt.getId();
			System.out.println("Credito: "+idCred);
			int nCuota = Integer.parseInt(cuota);
			TablaAmortizacion tablaAmort = new TablaAmortizacion();
			tablaAmort= tablaDAO.Tabla(nCuota, idCred);
			
			int idCredTabla = tablaAmort.getCredito().getId();
			System.out.println("Id Credito: "+ idCred +"| Id TablaAmortizacion Credito"+ idCredTabla);
			if (tablaAmort.getCredito().getId()==credito.getId()) {
				tablaAmort.setEstado("C");
				double total = tablaAmort.getSaldo();
				double cantidad = Double.parseDouble(monto);
				//tablaAmort.setSaldo(total- cantidad);
				tablaDAO.update(tablaAmort);
			} 
			url = "/emp/indexE.jsp";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error en pago");
			
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
