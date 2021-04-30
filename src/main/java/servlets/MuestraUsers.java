package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

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

/**
 * Servlet implementation class MuestraUsers
 */
@WebServlet("/MuestraUsers")
public class MuestraUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Session s;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuestraUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		s = HibernateUtil.getSessionFactory().openSession();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append("Mostrando usuarios");
		List<Usuarios> us = UsuariosDAO.getAllUsers(s);
		
		/*PrintWriter writer = response.getWriter();
		
		Iterator<Usuarios> it = us.iterator();
		
		while(it.hasNext()) {
			writer.println(it.next().toString());
		}*/
		
		request.setAttribute("listaUsers", us);
		request.getRequestDispatcher("mostrarUsers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
