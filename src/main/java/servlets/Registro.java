package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import controllers.RegistroController;
import daos.UsuariosDAO;
import modelos.Usuarios;
import utilidades.StringUtilities;
import utilidades.UsoLogger;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		log = UsoLogger.getLogger(Registro.class);
		log.info("Logger iniciados");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idrstr = request.getParameter("id_rol");
		if(idrstr == null) {
			idrstr = "3";//por defecto se crean clientes
		}
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		String nombre = request.getParameter("nombre");
		String ap1 = request.getParameter("ap1");
		String ap2 = request.getParameter("ap2");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		String telefono = request.getParameter("telefono");
		String dni = request.getParameter("dni");
		
		log.info("Parametros recogidos");
		boolean correcto = RegistroController.insertUserControl(idrstr, email, clave, nombre, ap1, ap2, direccion, localidad, provincia, telefono, dni);
		log.info("Usuario registrado");
		
		if(correcto) {
			HttpSession sesion = request.getSession(true);
			Usuarios us = (Usuarios)sesion.getAttribute("user");
			if(us == null) {
				us = UsuariosDAO.getLoginUser(email, clave);
				sesion.setAttribute("user", us);
				Date fecha;
				fecha = new Date();
				sesion.setAttribute("date", fecha);
			}
			request.getRequestDispatcher("BusquedaProductos").forward(request, response);
		}else {
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
		
		
	}

}
