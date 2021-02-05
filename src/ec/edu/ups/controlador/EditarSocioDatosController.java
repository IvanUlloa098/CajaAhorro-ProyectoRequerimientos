package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.SocioDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.gestion.Usuario;
import ec.edu.ups.socios.Socio;

/**
 * Servlet implementation class EditarSocioDatosController
 */
@WebServlet("/EditarSocioDatosController")
public class EditarSocioDatosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Usuario usuario;
	private UsuarioDAO usuariodao;
	
	
	
    public EditarSocioDatosController() {
        super();
        usuariodao = DAOFactory.getFactory().getUsuarioDAO();
        
        
        
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=null;
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cedula = request.getParameter("cedula");
		String url=null;
		
		usuario = usuariodao.buscarCedulaEmpledado(cedula);
		
		if(usuario != null) {
			System.out.println("usuario encontrado");
			request.setAttribute("usuario", usuario);
			url= "/admin/EditarSocioDatos2.jsp";
		}else {
			System.out.println("usuario no encontrado");
			url= "/admin/EditarSocioDatos.jsp";
		}
		
		//request.setAttribute("cuentas", listaCuentas);
		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}




