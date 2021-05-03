package daos;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import modelos.Productos;
import utilidades.HibernateUtil;

public class ProductosDAO {
	
	private static Session s;

	public static List<Productos> getAllProductos(){
		s = HibernateUtil.getSessionFactory().openSession();
		String hQuery = "from Productos";
		List<Productos> prod = s.createQuery(hQuery,Productos.class).list();
		s.close();
		return prod;
	}
	
	public static void insertProducto(int id_categoria,String nombre, String descripcion, double precio, int stock, Timestamp fecha_baja, float impuesto) {
		s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		Productos nuevo = new Productos(id_categoria,nombre,descripcion,precio,stock,fecha_baja,impuesto);
		s.save(nuevo);
		tx.commit();
		s.close();
	}
	
}
