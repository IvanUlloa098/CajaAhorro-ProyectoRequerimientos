package ec.edu.ups.controlador;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ec.edu.ups.creditos.CarteraCreditos;
import ec.edu.ups.creditos.Credito;
import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.creditos.TablaAmortizacion;
import ec.edu.ups.dao.CarteraCreditosDAO;
import ec.edu.ups.dao.CreditoDAO;
import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.SolicitudCreditoDAO;
import ec.edu.ups.dao.TablaAmortizacionDAO;
import ec.edu.ups.socios.CuentaAhorros;

/**
 * Servlet implementation class AceptarSolicitudController
 */
@WebServlet("/AceptarSolicitudController")
public class AceptarSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static Double TASA_CREDITO = 0.01;
	
	private SolicitudCredito solicitud;
	private Credito credito;
	private CarteraCreditos cartera; 
	private TablaAmortizacion tabla;
	private CuentaAhorros cuenta;
	
	private SolicitudCreditoDAO solicitudDAO;
	private CreditoDAO creditoDAO;
	private CarteraCreditosDAO carteraDAO;
	private TablaAmortizacionDAO tablaDAO;
	private CuentaAhorrosDAO cuentaAhorrosDAO;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AceptarSolicitudController() {
        super();
        solicitudDAO = DAOFactory.getFactory().getSolicitudCreditoDAO();
        creditoDAO = DAOFactory.getFactory().getCreditoDAO();
        carteraDAO = DAOFactory.getFactory().getCarteraCreditosDAO();
        tablaDAO= DAOFactory.getFactory().getTablaAmortizacionDAO();
        cuentaAhorrosDAO = DAOFactory.getFactory().getCuentaAhorrosDAO();
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
		
		List<TablaAmortizacion> aux = new ArrayList<TablaAmortizacion>();
		
		Optional<String> s = request.getParameterMap().keySet().stream().filter(e->e.contains("modificar_")).findFirst();
		Optional<String> s1 = request.getParameterMap().keySet().stream().filter(e->e.contains("eliminar_")).findFirst();
		
		try {
			if(s.isPresent()) {
				
				solicitud = solicitudDAO.read(Integer.parseInt(s.get().split("_")[1]));
				
				solicitud.setEstado('A');
				
				solicitudDAO.update(solicitud);
				interes= (int) (TASA_CREDITO*100);
				monto_real = solicitud.getMonto();
				
				cartera = new CarteraCreditos(0, 'A', 0);
				
				credito = new Credito((Double) monto_real, interes, solicitud.getCuotas(), 'A', fecha,  solicitud.getCuentaA(), cartera);
				
				carteraDAO.create(cartera);
				creditoDAO.create(credito);
				
				//Update Cuenta de Ahorros
				cuenta = new CuentaAhorros();
				cuenta = credito.getCuentaA();
				System.out.println("Cuenta Obtenida: " + cuenta.getNumero());
				double saldoA= cuenta.getSaldo();
				double montoR= solicitud.getMonto();
				cuenta.setSaldo(saldoA+montoR);
				cuentaAhorrosDAO.update(cuenta);
				
				//Crear Tabla de Amortizacion
				int tasa =10;
				int numeroCuotas = solicitud.getCuotas();
				double total= solicitud.getMonto();
				Double capital= total/ numeroCuotas;
				
				Double valorI = (Double) ((total/numeroCuotas)*(TASA_CREDITO));
				double pagoCoutas= capital+valorI;
				
				
				int idCre= credito.getId();
				System.out.println("Numero Cuotas: "+ numeroCuotas +" -- Tota:  " + total+"El Credito es: " + idCre);
				System.out.println("|"+ numeroCuotas+"|"+ total+ "|"+capital +"|"+ valorI+"|"+ pagoCoutas+"|"+tasa);
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
					tabla.setInteres(valorI);
					tabla.setNumCuota(i);
					tabla.setPagoTotal(pagoCoutas);
					total = total-(capital*(z));
                    tabla.setSaldo(total);
					tabla.setTasa(tasa);
					tabla.setCredito(credito);
					
					aux.add(tabla);
					
					tablaDAO.create(tabla);
					System.out.println("Fila Agregada");
					
					if (i==1) {
						z++;
					}
					
					
				}
				
				System.out.println(">>>>>>>>>>>>>  UPDATE RESPONSE FROM /AceptarSolicitudController");
				url= "/admin/indexA.jsp";
				
				this.createPDF(credito, aux);
				
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
	
	private void createPDF(Credito c, List<TablaAmortizacion> a) {
		
		
		try {
			Document documento = new Document();
			FileOutputStream ficheroPdf = new FileOutputStream("MiCredito.pdf");
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			
			documento.open();
			
			documento.add(new Paragraph("*****************TABLA DE AMORTIZACION*****************"));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*	 NOMBRE DEL PROPIETARIO: "+c.getCuentaA().getSocio().getNombre().toUpperCase() + " "+c.getCuentaA().getSocio().getApellido().toUpperCase()));
			documento.add(new Paragraph("*	 NUMERO DE CUENTA: "+c.getCuentaA().getNumero()));
			documento.add(new Paragraph("*	 NUMERO DE CEDULA: "+c.getCuentaA().getSocio().getCedula()));
			documento.add(new Paragraph("*	 MONTO SOLICITADO: "+c.getMonto()));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph(" "));
			
			PdfPTable tabla = new PdfPTable(8);
			
			tabla.addCell("CUOTA");
			tabla.addCell("FECHA VENCIMIENTO");
			tabla.addCell("TASA");
			tabla.addCell("CAPITAL");
			tabla.addCell("INTERES");
			tabla.addCell("PAGO TOTAL");
			tabla.addCell("SALDO");
			tabla.addCell("ESTADO");
			
			for (TablaAmortizacion t: a) {
				
				tabla.addCell(t.getNumCuota()+"");
				tabla.addCell(t.getFechaVenc()+"");
				tabla.addCell(t.getTasa()+"");
				tabla.addCell(t.getCapital()+"");
				tabla.addCell(t.getInteres()+"");
				tabla.addCell(t.getPagoTotal()+"");
				tabla.addCell(t.getSaldo()+"");
				tabla.addCell(t.getEstado()+"");
				
			}
			
			documento.add(tabla);
						
			documento.close();
			
			System.out.println(">>>>>>>>> PDF CREADO");
			
		} catch (FileNotFoundException e) {
			System.out.println(">>>>>>>>> ERROR (RealizarTransaccionController)");
			e.printStackTrace();
		} catch (DocumentException e) {
			System.out.println(">>>>>>>>> ERROR (RealizarTransaccionController)");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
 
}
