package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.internal.jpa.metadata.accessors.mappings.EmbeddedIdAccessor;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.gestion.Caja;
import ec.edu.ups.gestion.Rol;
import ec.edu.ups.gestion.Usuario;

/**
 * Servlet implementation class IniciarSesionController
 */
@WebServlet("/IniciarSesionController")
public class IniciarSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDao;
	private Usuario usuario;
	private Rol roles;
    private Caja caja;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesionController() {
        super();
        usuarioDao= DAOFactory.getFactory().getUsuarioDAO();
        usuario = new Usuario();        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String url = null;
		String rol= null;
		String username = null;
		String password = null;
		
		try {
			String V1= request.getParameter("username");
			String V2= request.getParameter("pass");
			System.out.println("V1: " +V1+" V2: "+V2);
			
			usuario=usuarioDao.Login(V1, V2);
			username = usuario.getUsername();
			password = usuario.getPassword();
			roles = usuario.getRol();
			rol= roles.getRol();
			System.out.println("User: "+username + "Password: "+ password +" Rol: "+rol);
			
			if (V1.equals(username) & V2.equals(password)) {
				HttpSession  session=request.getSession(true);
				
				session.setAttribute("ID", usuario.getId());
				session.setAttribute("Nombre", usuario.getNombre());
				session.setAttribute("caja_id", usuario.getCaja().getId());
				System.out.println("Datos correctos");
				if (rol.equals("ADMINISTRADOR")) {
					System.out.println("Es Admin");
					url= "/admin/indexA.jsp";
				}else {
					System.out.println("Es empleado");
					url= "/emp/indexE.jsp";
				}	
			}else {
				url= "/sesion.jsp";
			}
			
			request.setAttribute("usuario", usuario);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
			/*
			try {
				usuario=usuarioDao.Sesion(V1, V2);
				 username = usuario.getUsername();
				 password = usuario.getPassword();
				System.out.println("User: "+username + "Password: "+ password);
				
				roles = usuario.getRol();
				rol= roles.getRol();
				System.out.println("El rol es: "+rol);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error");
			}
			
			if (V1.equals(username) & V2.equals(password)) {
				System.out.println("Si existe el Usuario");
				session.setAttribute("Usuario", usuario);
				session.setAttribute("caja", caja);
				
				if (rol.equals("ADMINISTRADOR")) {
					System.out.println("Es Admin");
					url= "/admin/indexA.jsp";
				}else {
					System.out.println("Es empleado");
					url= "/emp/indexE.jsp";
				}
				
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al ingresar");
			PrintWriter pw=response.getWriter();
			response.setContentType("text/html");  
			response.sendRedirect("/CajaAhorro-ProyectoRequerimientos/sesion.jsp");
			pw.close(); 
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HtpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
    }
		
}
