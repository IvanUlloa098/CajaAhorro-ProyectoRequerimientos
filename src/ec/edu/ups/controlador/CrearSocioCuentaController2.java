package ec.edu.ups.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CuentaAhorrosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PlanCuentasDAO;
import ec.edu.ups.dao.SocioDAO;
import ec.edu.ups.gestion.Persona;
import ec.edu.ups.socios.CuentaAhorros;
import ec.edu.ups.socios.PlanCuentas;
import ec.edu.ups.socios.Socio;

/**
 * Servlet implementation class CrearSocioCuentaController2
 */
@WebServlet("/CrearSocioCuentaController2")
public class CrearSocioCuentaController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SocioDAO socioDao;
	private PlanCuentasDAO planesCuentaDao;
	private CuentaAhorrosDAO cuentaDao;
	
	private Persona persona;
	private Socio socio;
	private PlanCuentas planes;
	private CuentaAhorros cuenta;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearSocioCuentaController2() {
        super();
        socioDao= DAOFactory.getFactory().getSocioDAO();
        planesCuentaDao= DAOFactory.getFactory().getPlanCuentasDAO();
        cuentaDao= DAOFactory.getFactory().getCuentaAhorrosDAO();
        persona = new Persona(); 
        socio = new Socio();
        planes = new PlanCuentas();
        cuenta = new CuentaAhorros();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url=null;
		char estadoSocio = 'A';
		int numero1 =0;
		int numero2=0;
		char estadoCuenta ='X';
		try {
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String cedula = request.getParameter("cedula");
			String telefono = request.getParameter("telefono");
			String direccion = request.getParameter("direccion");
			String email = request.getParameter("email");
			String estadoC= request.getParameter("estado");
			String nombrePlan = request.getParameter("plan");
			String saldo = request.getParameter("saldo");
			System.out.println("|"+nombre+"|"+"|"+apellido+"|"+"|"+cedula+"|"+"|"+estadoC+"|"+"|"+nombrePlan+"|"+"|"+saldo+"|");
			try {
				//Creacion del Socio
			socio = new Socio();
			socio.setApellido(apellido);
			socio.setNombre(nombre);
			socio.setCedula(cedula);
			socio.setTelefono(telefono);
			socio.setDireccion(direccion);
			socio.setEmail(email);
			socio.setEstado(estadoSocio);
			socioDao.create(socio);
			System.out.println("El Id del Socio Nuevo es: "+socio.getCedula()+ " ID: "+socio.getId());
			System.out.println("--------------------------------------------------------------------");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				//Busqueda de Plan de Cuentas 
				planes=planesCuentaDao.buscarPlanes(nombrePlan); 
				System.out.println("El plan es: "+ planes.getDescrip());
				
				//Buscar Socio para Agregar a la Cuenta 
				Socio socio2 = new Socio();
				socio2 = socioDao.buscarSocio(request.getParameter("cedula"));
				System.out.println("Cedula2 de la busqueda: "+socio2.getId());
				
				//Creacion de la Cuenta
				//Fecha
				java.util.Date d = new java.util.Date();  
				SimpleDateFormat plantilla = new SimpleDateFormat("dd/MM/yyyy H:mm");
				String tiempo = plantilla.format(d);
				java.sql.Date date2 = new java.sql.Date(d.getTime());
				System.out.println("Fecha actual: "+ date2);
				
				estadoCuenta = estadoC.charAt(0);
				double cantidad = Double.parseDouble(saldo);
				
				numero1 = (int) (10000 + Math.random() * 90000);
				numero2 = (int) (10000 + Math.random() * 90000);
				
				String n1= Integer.toString(numero1);
				String n2= Integer.toString(numero2);
				
				String numeroCuenta = n1+n2;
				System.out.println("Numero Cuenta es : "+numeroCuenta);
				
				cuenta = new CuentaAhorros();
				cuenta.setEstado(estadoCuenta);
				cuenta.setFechaCreacion(date2);
				cuenta.setNumero(numeroCuenta);
				cuenta.setPlanesCuentas(planes);
				cuenta.setSocio(socio2);
				cuenta.setSaldo(cantidad);
				cuentaDao.create(cuenta);
				System.out.println("-------------------------------------");
				url= "/emp/indexE.jsp";	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
