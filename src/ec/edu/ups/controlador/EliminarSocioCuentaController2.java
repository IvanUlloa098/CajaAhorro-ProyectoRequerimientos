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
 * Servlet implementation class EliminarSocioCuentaController2
 */
@WebServlet("/EliminarSocioCuentaController2")
public class EliminarSocioCuentaController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SocioDAO sociodao;
	private Socio socio;
	
	private CuentaAhorrosDAO cuentadao;
	private CuentaAhorros cuentaahorros;
	private List<CuentaAhorros> listaCuentas;
	
	public EliminarSocioCuentaController2() {
        super();
        sociodao = DAOFactory.getFactory().getSocioDAO();
        cuentadao = DAOFactory.getFactory().getCuentaAhorrosDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
				String numero = request.getParameter("numero");
				String cedula = request.getParameter("cedula");
				
				String url= null;
				try {
					
					cuentaahorros = cuentadao.find_numero(numero);
					
					if(cuentaahorros != null ) {
						System.out.println("encuentra");
						
						CuentaAhorros cue = new CuentaAhorros();
						cue = cuentadao.find_numero(numero);
						cue.setEstado('I');
						
						cuentadao.update(cue);
						
					}else {
						System.out.println("no se encontro num cuenta");
					}
					
					
					socio = sociodao.buscarSocio(cedula);
					char p = 'I';
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
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		String url= "/emp/indexE.jsp";
				
				
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
	
	}

}
