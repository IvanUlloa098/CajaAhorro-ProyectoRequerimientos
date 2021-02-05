package ec.edu.ups.controlador;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ec.edu.ups.aporte_ahorros.Movimiento;
import ec.edu.ups.aporte_ahorros.TipoMovimiento;
import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.MovimientoDAO;
import ec.edu.ups.dao.TipoMovimientoDAO;
import ec.edu.ups.socios.CuentaAhorros;

/**
 * Servlet implementation class TransferenciaController
 */
@WebServlet("/TransferenciaController")
public class TransferenciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CuentaAhorrosDAO cuentaAhorrosDao;
	private CuentaAhorros cuentaA1;
	private CuentaAhorros cuentaA2;
	private List<CuentaAhorros> listaCuentas;
	private MovimientoDAO movimientoDao;
	private TipoMovimientoDAO tipomovDao;
	private List<TipoMovimiento> listaTipoMov;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferenciaController() {
       cuentaAhorrosDao = DAOFactory.getFactory().getCuentaAhorrosDAO();
       movimientoDao = DAOFactory.getFactory().getMovimientoDAO();
       tipomovDao = DAOFactory.getFactory().getTipoMovimientoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/emp/Mensaje.jsp";
		cuentaA1 = new CuentaAhorros();
		cuentaA2 = new CuentaAhorros();
		String mensaje = null;
		listaCuentas = new ArrayList<CuentaAhorros>();
		Double aux = 0.0;
		try {
			String cuenta1 = request.getParameter("cuenta1");
			String cuenta2 = request.getParameter("cuenta2");
			Double monto = Double.parseDouble(request.getParameter("monto"));
			
			//Chequear si tiene el monto para la transferencia
			listaCuentas = cuentaAhorrosDao.findAll();
			//recuperamos los obj de cuentas
			for (int i = 0; i < listaCuentas.size(); i++) {
				if (listaCuentas.get(i).getNumero().equals(cuenta1)) {
					//System.out.println("Obtiene cuenta1");
					cuentaA1 = listaCuentas.get(i);
				}
				if (listaCuentas.get(i).getNumero().equals(cuenta2)) {
					cuentaA2 = listaCuentas.get(i);
					//System.out.println("Obtiene cuenta2");
				}
			}
			if (cuentaA1.getSaldo()>=monto) {
				//Se acepta la transferencia
				aux = cuentaA1.getSaldo();
				cuentaA1.setSaldo(aux-monto);
				cuentaAhorrosDao.update(cuentaA1);
				aux = cuentaA2.getSaldo();
				cuentaA2.setSaldo(aux+monto);
				cuentaAhorrosDao.update(cuentaA2);
				
				//Creamos los movimientos
				java.util.Date d = new java.util.Date();
				java.sql.Date date2 = new java.sql.Date(d.getTime());
				//mov 1
				//
				TipoMovimiento t = new TipoMovimiento();
				listaTipoMov = new ArrayList<TipoMovimiento>();
				listaTipoMov = tipomovDao.findAll();
				for (int i = 0; i <listaTipoMov.size(); i++) {
					if (listaTipoMov.get(i).getNombre().equals("TRANSFERENCIA")) {
						t=listaTipoMov.get(i);
					}
				}
				//
				Movimiento mov = new Movimiento();
				mov.setFecha(date2);
				mov.setMonto(0-monto);
				mov.setCuentaA(cuentaA1);
				mov.setTipoM(t);
				movimientoDao.create(mov);
				Movimiento mov1 = new Movimiento();
				mov1.setFecha(date2);
				mov1.setMonto(monto);
				mov1.setCuentaA(cuentaA2);
				mov1.setTipoM(t);
				movimientoDao.create(mov1);
				mensaje = "Transaccion realizada correctamente";
				
				this.createPDF(cuentaA1, cuentaA2, monto);
				
			}else {
				mensaje = "Saldo insuficiente";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Numero de cuenta no existe";
		}
		request.setAttribute("mensaje", mensaje);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	private void createPDF(CuentaAhorros c, CuentaAhorros c2, Double m) {
		
		
		try {
			Document documento = new Document();
			FileOutputStream ficheroPdf = new FileOutputStream("transferencia.pdf");
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
			
			documento.open();
			
			documento.add(new Paragraph("**********SU TRANSACCION HA SIDO REALIZADA CON EXITO**********"));
			documento.add(new Paragraph("**********************************¡GRACIAS!*************************************"));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*	 NUMERO DE CUENTA EMISORA: "+c.getNumero()));
			documento.add(new Paragraph("*	 NUMERO DE CUENTA REMITENTE: "+c2.getNumero()));
			documento.add(new Paragraph("*	 NUMERO DE CEDULA: "+c.getSocio().getCedula()));
			documento.add(new Paragraph("*	 MOVIMIENTO REALIZADO: TRANSFERENCIA"));
			documento.add(new Paragraph("*	 MONTO: "+m));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("*	 "));
			documento.add(new Paragraph("********************************************************************************"));
						
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
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
