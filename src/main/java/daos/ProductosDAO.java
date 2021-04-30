package daos;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import modelos.Productos;

public class ProductosDAO {

	public static List<Productos> getAllProductos(Session s){
		String hQuery = "from Productos";
		List<Productos> prod = s.createQuery(hQuery,Productos.class).list();
		
		return prod;
	}
	
	public static void insertProducto(Session s,int id_categoria,String nombre, String descripcion, double precio, int stock, Timestamp fecha_baja, float impuesto) {
		Transaction tx = s.beginTransaction();
		Productos nuevo = new Productos(id_categoria,nombre,descripcion,precio,stock,fecha_baja,impuesto);
		s.save(nuevo);
		tx.commit();
	}
	
}
