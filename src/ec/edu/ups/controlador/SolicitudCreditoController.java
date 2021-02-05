package ec.edu.ups.controlador;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ec.edu.ups.creditos.SolicitudCredito;
import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.SolicitudCreditoDAO;
import ec.edu.ups.socios.CuentaAhorros;

/**
 * Servlet implementation class SolicitudCreditoController
 */
@WebServlet("/SolicitudCreditoController")
public class SolicitudCreditoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private CuentaAhorros ca;
	private SolicitudCredito solicitud;
	
	private CuentaAhorrosDAO cuentaDAO;
	private SolicitudCreditoDAO solicitudDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitudCreditoController() {
        super();
        cuentaDAO = DAOFactory.getFactory().getCuentaAhorrosDAO();
        solicitudDAO = DAOFactory.getFactory().getSolicitudCreditoDAO();
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
		String url = null;
		Date date = new Date();
		
		try {
			
			HttpSession  session=request.getSession(true);
			
			String monto = request.getParameter("monto");
			String cuenta = request.getParameter("cuenta");
			String cedula = request.getParameter("cedula");
			String descripcion = request.getParameter("descripcion");
			String cuotas = request.getParameter("cuotas");
			
			ca = cuentaDAO.find_numero(cuenta);
			
			solicitud = new SolicitudCredito('E', date, Double.valueOf(monto), descripcion, ca, Integer.valueOf(cuotas));
			
			solicitudDAO.create(solicitud);
			
			solicitud = new SolicitudCredito();
			System.out.println(">>>>>> SOLICITUD EN ESPERA");
			url= "/emp/indexE.jsp";
			
			this.createPDF(ca, solicitud);
			
		} catch (Exception e) {
			url= "/emp/solicitarCredito.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}
	private void createPDF(CuentaAhorros c, SolicitudCredito s) {
		
		
		try {
			Document documento = new Document();
			FileOutputStream ficheroPdf = new FileOutputStream("solicitud.pdf");
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			
			documento.open();
			
			documento.add(new Paragraph("***********SU SOLICITUD HA SIDO REALIZADA CON EXITO***********"));
			documento.add(new Paragraph("**********************************¡GRACIAS!*************************************"));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*	 NUMERO DE CUENTA: "+c.getNumero()));
			documento.add(new Paragraph("*	 NUMERO DE CEDULA: "+c.getSocio().getCedula()));
			documento.add(new Paragraph("*	 MONTO SOLICITADO: "+s.getMonto()));
			documento.add(new Paragraph("*	 CUOTAS: "+s.getCuotas()));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*******************************************************************************"));
						
			documento.close();
			
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
