package ec.edu.ups.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.internal.databaseaccess.InOutputParameterForCallableStatement;

import ec.edu.ups.creditos.CarteraCreditos;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.creditos.TablaAmortizacion;
import ec.edu.ups.dao.CarteraCreditosDAO;
import ec.edu.ups.dao.CreditoDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.SolicitudCreditoDAO;
import ec.edu.ups.dao.TablaAmortizacionDAO;

/**
 * Servlet implementation class AceptarSolicitudController
 */
@WebServlet("/AceptarSolicitudController")
public class AceptarSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SolicitudCredito solicitud;
	private Credito credito;
	private CarteraCreditos cartera; 
	private TablaAmortizacion tabla;
	
	private SolicitudCreditoDAO solicitudDAO;
	private CreditoDAO creditoDAO;
	private CarteraCreditosDAO carteraDAO;
	private TablaAmortizacionDAO tablaDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AceptarSolicitudController() {
        super();
        solicitudDAO = DAOFactory.getFactory().getSolicitudCreditoDAO();
        creditoDAO = DAOFactory.getFactory().getCreditoDAO();
        carteraDAO = DAOFactory.getFactory().getCarteraCreditosDAO();
        tablaDAO= DAOFactory.getFactory().getTablaAmortizacionDAO();
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
		
		String url= null;
		Double monto_real;
		Date fecha = new Date();
		int interes;
		
		Optional<String> s = request.getParameterMap().keySet().stream().filter(e->e.contains("modificar_")).findFirst();
		Optional<String> s1 = request.getParameterMap().keySet().stream().filter(e->e.contains("eliminar_")).findFirst();
		
		try {
			if(s.isPresent()) {
				
				solicitud = solicitudDAO.read(Integer.parseInt(s.get().split("_")[1]));
				
				solicitud.setEstado('A');
				
				solicitudDAO.update(solicitud);
				interes=10;
				monto_real = solicitud.getMonto() - (solicitud.getMonto() * 0.1);
				
				cartera = new CarteraCreditos(0, 'A', 0);
				
				credito = new Credito((Double) monto_real, 10, solicitud.getCuotas(), 'A', fecha,  solicitud.getCuentaA(), cartera);
				
				carteraDAO.create(cartera);
				creditoDAO.create(credito);
				
				//Crear Tabla de Amortizacion 
				int tasa =interes/100;
				int numeroCuotas = solicitud.getCuotas();
				double total= solicitud.getMonto();
				double obtenerTasa = (double) interes/100;
				double obtenerPagoTotal = (double) (total*obtenerTasa)/( 1-Math.pow((1+obtenerTasa), -numeroCuotas)); 
				double capital= total/ numeroCuotas;
				//double interes1= tasa*total;
				double obtenerInteres = (double) (total*obtenerTasa);
				int idCre= credito.getId();
				System.out.println("Numero Cuotas: "+ numeroCuotas +" -- Tota:  " + total+"El Credito es:" + idCre);
				
				System.out.println("|"+ numeroCuotas+"|"+ total+ "|"+obtenerPagoTotal +"|"+ capital+"|"+ obtenerInteres+"|"+interes);
				/*solicitud.getCuentaA();
				System.out.println("Numero ");
				*/
				int z = 0;
				for (int i = 1; i < numeroCuotas+1 ; i++) {
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(fecha);
					cal.add(Calendar.MONTH, 1);
					fecha = cal.getTime();
					System.out.println("Cuota "+ i);
					System.out.println(fecha);
					
					TablaAmortizacion tabla = new TablaAmortizacion();
					tabla.setId(0);
					tabla.setCapital(capital);
					tabla.setEstado("P");
					tabla.setFechaVenc(fecha);
					tabla.setInteres(obtenerInteres);
					tabla.setNumCuota(i);
					tabla.setPagoTotal(obtenerPagoTotal);
					total = total-(obtenerPagoTotal*(z));
                    tabla.setSaldo(total);
					tabla.setTasa(interes);
					tabla.setCredito(credito);
					tablaDAO.create(tabla);
					System.out.println("Fila Agregada");
					if (i==1) {
						z++;
					}
				}
				
				System.out.println(">>>>>>>>>>>>>  UPDATE RESPONSE FROM /AceptarSolicitudController");
				url= "/admin/indexA.jsp";
			} else {
				
				solicitud = solicitudDAO.read(Integer.parseInt(s1.get().split("_")[1]));
				
				solicitud.setEstado('D');
				
				solicitudDAO.update(solicitud);
				
				System.out.println(">>>>>>>>>>>>>  DELETE RESPONSE FROM /AceptarSolicitudController");
				url= "/admin/indexA.jsp";
			}
		} catch (Exception e2) {
			System.out.println(">>>>>>>>>>>>>  ERROR RESPONSE FROM /AceptarSolicitudController");
			url= "/admin/aprobarCredito.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
 
}
