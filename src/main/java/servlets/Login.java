package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import daos.UsuariosDAO;
import modelos.Usuarios;
import utilidades.HibernateUtil;
import utilidades.UsoLogger;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Logger log;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		log = UsoLogger.getLogger(Login.class);
		log.info("Sesion iniciada");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String email;
		String clave;
		email = request.getParameter("email");
		clave = request.getParameter("clave");
		
		log.info("Parametros obtenidos "+email+" "+clave);
		
		//PrintWriter writer = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath()).append(email).append(clave);
		
		Usuarios us = UsuariosDAO.getLoginUser(email, clave);
		log.info("Posible usuario adquirido");
		
		if(us != null) {
			//writer.println("Bienvenido "+us.getNombre() +" por POST");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("user", us);
			Date fecha;
			fecha = new Date();
			sesion.setAttribute("date", fecha);
			request.getRequestDispatcher("BusquedaProductos").forward(request, response);
		}else {
			request.setAttribute("mensaje", "Error de autentificacion, comprueba tu correo o contraseña");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
