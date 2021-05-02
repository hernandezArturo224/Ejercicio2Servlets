package servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import daos.ProductosDAO;
import utilidades.*;

/**
 * Servlet implementation class InsertaProducto
 */
@WebServlet("/InsertaProducto")
public class InsertaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Session s;
	private static Logger log;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertaProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		log = UsoLogger.getLogger(InsertaProducto.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
		
		//response.getWriter().append(fecha_baja+" ").append(sto);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean correcto = true;
		
		String id_cat = request.getParameter("id_categoria");
		int id_categoria=0;
		if(id_cat.equals("")) {
			correcto = false;
		}else {
			id_categoria = Integer.parseInt(id_cat);
		}
		
		String fecha = request.getParameter("fecha_baja");
		Timestamp fecha_baja = StringUtilities.getDefaultTimestamp();
		if(fecha.equals("")) {
			correcto = false;
		}else {
			fecha_baja = StringUtilities.getTimestampFromString(fecha);
		}
		
		
		String sto = request.getParameter("stock");
		int stock=50;
		if(sto.equals("")) {
			//correcto = false;
		}else {
			stock = Integer.parseInt(sto);
		}
		
		String imp = request.getParameter("impuesto");
		float impuesto=21;
		if(imp.equals("")) {
			//correcto = false;
		}else {
			impuesto = Float.parseFloat(imp);
		}
		
		String descripcion = request.getParameter("descripcion");
		String nombre = request.getParameter("nombre");
		String pre = request.getParameter("precio");
		double precio=50.5;
		if(pre.equals("")) {
			//correcto = false;
		}else {
			precio = Double.parseDouble(pre);
		}
		
		
		if(correcto) {
			s = HibernateUtil.getSessionFactory().openSession();
			ProductosDAO.insertProducto(s, id_categoria, nombre, descripcion, precio, stock, fecha_baja, impuesto);
			s.close();
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("insercionProducto.jsp").forward(request, response);
		}
		
	}

}
