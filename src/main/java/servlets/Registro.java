package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import daos.UsuariosDAO;
import utilidades.HibernateUtil;
import utilidades.UsoLogger;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Session s;
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
		s=HibernateUtil.getSessionFactory().openSession();
		log = UsoLogger.getLogger(Registro.class);
		log.info("Logger y sesion iniciados");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		int id_rol = Integer.parseInt(request.getParameter("id_rol"));
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
		UsuariosDAO.insertUser(s,id,id_rol,email,clave,nombre,ap1,ap2,direccion,localidad,provincia,telefono,dni );
		log.info("Usuario registrado");
		
		response.getWriter().append("Inserción realizada..");	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idstr = request.getParameter("id");
		String idrstr = request.getParameter("id_rol");
		if(idstr.equals("") || idrstr.equals("")) {
			response.getWriter().append("Tienes que introducir al menos la id y el rol");
		}else{
			int id = Integer.parseInt(idstr);
			if(UsuariosDAO.compruebaIdExistente(s, id)) {
				response.getWriter().append("Ya hay un usuario con la id existente");
			}else {
				int id_rol = Integer.parseInt(idrstr);
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
				UsuariosDAO.insertUser(s,id,id_rol,email,clave,nombre,ap1,ap2,direccion,localidad,provincia,telefono,dni );
				log.info("Usuario registrado");
				
				response.getWriter().append("Inserción realizada..");	
			}//else2
		}//else1
		
		
	}

}
