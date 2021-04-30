package daos;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelos.Categorias;
import modelos.Roles;

public class CategoriasDAO {
	
	public static List<Categorias> getAllCategorias(Session s){
		String hQuery = "from Categorias";
		List<Categorias> cat = s.createQuery(hQuery,Categorias.class).list();
		
		return cat;
	}
	
	public static void insertCategoria(Session s,String nombre, String descripcion) {
		Transaction tx = s.beginTransaction();
		Categorias nuevo = new Categorias(nombre,descripcion);
		s.save(nuevo);
		tx.commit();
	}
	

}
