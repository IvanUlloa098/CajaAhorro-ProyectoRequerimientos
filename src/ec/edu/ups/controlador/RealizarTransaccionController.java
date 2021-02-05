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

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ec.edu.ups.aporte_ahorros.Movimiento;
import ec.edu.ups.aporte_ahorros.TipoMovimiento;
import ec.edu.ups.dao.CajaDAO;
import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DiarioCajaDAO;
import ec.edu.ups.dao.MovimientoDAO;
import ec.edu.ups.dao.TipoMovimientoDAO;
import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.DiarioCaja;
import ec.edu.ups.socios.CuentaAhorros;

/**
 * Servlet implementation class RealizarTransaccionController
 */
@WebServlet("/RealizarTransaccionController")
public class RealizarTransaccionController extends HttpServlet {
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
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizarTransaccionController() {
        super();
        diarioDAO = DAOFactory.getFactory().getDiarioCajaDAO();
        movDAO = DAOFactory.getFactory().getMovimientoDAO();
        tipoDAO = DAOFactory.getFactory().getTipoMovimientoDAO();
        cuentaDAO = DAOFactory.getFactory().getCuentaAhorrosDAO();
        cajaDao= DAOFactory.getFactory().getCajaDAO();
        
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
			int cid = Integer.valueOf(session.getAttribute("caja_id").toString());
			int t = Integer.valueOf(request.getParameter("tipo"));
			Double aux_ca;
			Double aux_caja;
			
			tipo = tipoDAO.read(t);
			ca = cuentaDAO.find_numero(cuenta);			
			caja = cajaDao.read(cid);
			
			if ((tipo.getNombre().equals("DEPOSITO")) && (ca.getSocio().getCedula().equals(cedula))) {
						
								
				movimiento = new Movimiento(0, date, Double.valueOf(monto), tipo, ca);
				
				diario = new DiarioCaja(date, caja, movimiento);
				
				ca.addDeposito(Double.valueOf(monto));	
				
				caja.setSaldo(caja.getSaldo()+Double.valueOf(monto));
				
				movDAO.create(movimiento);
				diarioDAO.create(diario);
				cuentaDAO.update(ca);
				cajaDao.update(caja);
				
				url= "/emp/indexE.jsp";
				
				this.createPDF(ca, movimiento);
				
			} else if ((tipo.getNombre().equals("RETIRO")) && (ca.getSocio().getCedula().equals(cedula))) {
				
				aux_ca = ca.getSaldo()-Double.valueOf(monto);
				aux_caja = caja.getSaldo()-Double.valueOf(monto);
				
				if ((aux_ca>0) && (aux_caja>0)) {
					
					movimiento = new Movimiento(0, date, Double.valueOf(monto)*(-1), tipo, ca);
					
					diario = new DiarioCaja(date, caja, movimiento);
					
					ca.addRetiro(Double.valueOf(monto));	
					
					caja.setSaldo(aux_caja);
					
					movDAO.create(movimiento);
					diarioDAO.create(diario);
					cuentaDAO.update(ca);
					cajaDao.update(caja);
					
					url= "/emp/indexE.jsp";
					
					this.createPDF(ca, movimiento);
					
					
					
				} else {
					System.out.println("ERROR>>>> CAJA O CUENTA VACIA");
					ca = null;
					caja = null;
					
					url= "/CargarTiposController";
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println(">>>WARNING (RealizarTransaccionController): " + e.getMessage());
			url= "/CargarTiposController";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}
	
	private void createPDF(CuentaAhorros c, Movimiento m) {
		
		
		try {
			Document documento = new Document();
			FileOutputStream ficheroPdf = new FileOutputStream("transaccion.pdf");
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			
			documento.open();
			
			documento.add(new Paragraph("**********SU TRANSACCION HA SIDO REALIZADA CON EXITO**********"));
			documento.add(new Paragraph("**********************************¡GRACIAS!*************************************"));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*	 NOMBRE DEL PROPIETARIO: "+c.getSocio().getNombre().toUpperCase() + " "+c.getSocio().getApellido().toUpperCase()));
			documento.add(new Paragraph("*	 NUMERO DE CUENTA: "+c.getNumero()));
			documento.add(new Paragraph("*	 NUMERO DE CEDULA: "+c.getSocio().getCedula()));
			documento.add(new Paragraph("*	 MOVIMIENTO REALIZADO: "+m.getTipoM().getNombre()));
			documento.add(new Paragraph("*	 MONTO: "+m.getMonto()));
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
