package servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import daos.RolesDAO;
import utilidades.HibernateUtil;
import utilidades.UsoLogger;

/**
 * Servlet implementation class InsertaRol
 */
@WebServlet("/InsertaRol")
public class InsertaRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertaRol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		log = UsoLogger.getLogger(InsertaRol.class);
		log.info("Sesion y logger creados");
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
String idstr = request.getParameter("id");
		
		if(idstr.equals("")) {
			response.getWriter().append("Introduce una Id minimo");
			log.debug("Id no introducida");
			request.getRequestDispatcher("insercionRol.jsp").forward(request, response);
		}else {
			int id = Integer.parseInt(idstr);
			if(RolesDAO.getIdExistente(id)) {
				response.getWriter().append("El id ya existe en la BBDD");
				request.getRequestDispatcher("insercionRol.jsp").forward(request, response);
			}else {
				String rol = request.getParameter("rol");
				RolesDAO.insertRol(id, rol);
				response.getWriter().append("Rol insertado");
				request.getRequestDispatcher("BusquedaProductos").forward(request, response);
			}
		}
	}

}
