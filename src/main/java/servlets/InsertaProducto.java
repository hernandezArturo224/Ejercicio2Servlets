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

import controllers.ProductosController;
import daos.ProductosDAO;
import utilidades.*;

/**
 * Servlet implementation class InsertaProducto
 */
@WebServlet("/InsertaProducto")
public class InsertaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		
		String id_cat = request.getParameter("id_categoria");
		String fecha = request.getParameter("fecha_baja");
		String sto = request.getParameter("stock");
		String imp = request.getParameter("impuesto");
		String descripcion = request.getParameter("descripcion");
		String nombre = request.getParameter("nombre");
		String pre = request.getParameter("precio");
		
		
		boolean correcto = ProductosController.insertProductoControl(id_cat, fecha, sto, imp, pre, descripcion, nombre);
		if(correcto) {
			request.getRequestDispatcher("BusquedaProductos").forward(request, response);
		}else {
			request.getRequestDispatcher("insercionProducto.jsp").forward(request, response);
		}
		
	}

}
