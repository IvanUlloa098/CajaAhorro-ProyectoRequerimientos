package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.creditos.Credito;
import ec.edu.ups.dao.CreditoDAO;
import ec.edu.ups.dao.DAOFactory;


/**
 * Servlet implementation class ListaCreditosAprobados
 */
@WebServlet("/ListaCreditosAprobadosController")
public class ListaCreditosAprobadosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private CreditoDAO creditoDao;
	private List<Credito> creditos;
	private Credito credito;

    public ListaCreditosAprobadosController() {
    	creditoDao = DAOFactory.getFactory().getCreditoDAO();
    	credito = new Credito();
    	
    	
    	
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		/*
		credito.setMonto(2000);
		credito.setInteres(3);
		credito.setNumeroCuota(2);
		credito.setEstado('A');
		
		creditoDao.create(credito);
		
		System.out.println("ver si crea C.");
		*/
		
		try {
			
			creditos = creditoDao.findAll();
			
			System.out.println("tamaño :" + creditos.size());
			
			request.setAttribute("creditos", creditos);
			url = "/admin/listaCreditosAprobados.jsp";
		} catch (Exception e) {
			System.out.println("Error Lista Creditos: " + e);
			//url = "/JSPs/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}

}
