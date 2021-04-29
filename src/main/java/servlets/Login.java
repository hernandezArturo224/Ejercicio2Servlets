package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
	private Session s;
	
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
		s=HibernateUtil.getSessionFactory().openSession();
		log = UsoLogger.getLogger(Login.class);
		log.info("Sesion iniciada");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email;
		String clave;
		email = request.getParameter("email");
		clave = request.getParameter("clave");
		
		log.info("Parametros obtenidos "+email+" "+clave);
		
		PrintWriter writer = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath()).append(email).append(clave);
		
		Usuarios us = UsuariosDAO.getLoginUser(s, email, clave);
		log.info("Posible usuario adquirido");
		
		if(us != null) {
			writer.println("Bienvenido "+us.getNombre()+" por GET");
		}else {
			
			request.getRequestDispatcher("login.html").forward(request, response);
		}
		
		
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
		
		PrintWriter writer = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath()).append(email).append(clave);
		
		Usuarios us = UsuariosDAO.getLoginUser(s, email, clave);
		log.info("Posible usuario adquirido");
		
		if(us != null) {
			//writer.println("Bienvenido "+us.getNombre() +" por POST");
			String name = us.getNombre();
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("nombre", name);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

}
