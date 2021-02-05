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
			
			List<CuentaAhorros> listcuentas = new ArrayList<CuentaAhorros>();
			listcuentas= cuentaDAO.findAll();
			
			CuentaAhorros cueAh = new CuentaAhorros();
			Credito credito = new Credito();
			List<Credito> cred = null;
			
			for (int i = 0; i < listcuentas.size(); i++) {
				if (listcuentas.get(i).getNumero().equals(cuenta)) {
					cueAh = listcuentas.get(i);
					cred =  new ArrayList<>(cueAh.getCredito());
					credito= cred.get(0);
				}
			}
			
			//Agregar a la tabla pagocuota
			PagoCuotas pago = new PagoCuotas();
			pago .setCredito(credito);
			pago.setId(0);
			pago.setMontoPag(Double.parseDouble(monto));
			pago.setFecha(new Date());
			
			pagoDAO.create(pago);
			
			//Modificar la tabla de amortizacion
			TablaAmortizacion t = new TablaAmortizacion();
			List<TablaAmortizacion> listTabla = new ArrayList<TablaAmortizacion>();
			List<TablaAmortizacion> aux_tabla = new ArrayList<TablaAmortizacion>();
			listTabla = tablaDAO.findAll();
			
			for (int i = 0; i < listTabla.size(); i++) {
				if (listTabla.get(i).getCredito().getCuentaA().equals(credito.getCuentaA())) {
					aux_tabla.add(listTabla.get(i));
				}
			}
			
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
				tablaAmort.setSaldo(total- cantidad);
				tablaDAO.update(tablaAmort);
			} 
			/*for (int i = 0; i < aux_tabla.size(); i++) {
				if (aux_tabla.get(i).getNumCuota()==Integer.parseInt(cuota)) {
					t = aux_tabla.get(i);
					
				}System.out.println("Entro---------------" + Integer.parseInt(cuota) );
				System.out.println("Cuota Aux Table ---------------" + aux_tabla.get(i).getNumCuota());
			}
			
			t.setEstado("C");
			Double aa = t.getSaldo();
			t.setSaldo(aa-Double.parseDouble(monto));
			
			tablaDAO.update(t);*/
		
			url = "/emp/indexE.jsp";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error en pago");
			
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
