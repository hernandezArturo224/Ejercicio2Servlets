package daos;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelos.Categorias;
import utilidades.HibernateUtil;

public class CategoriasDAO {
	
	private static Session s;
	
	public static List<Categorias> getAllCategorias(){
		s = HibernateUtil.getSessionFactory().openSession();
		String hQuery = "from Categorias";
		List<Categorias> cat = s.createQuery(hQuery,Categorias.class).list();
		s.close();
		return cat;
	}
	
	public static void insertCategoria(String nombre, String descripcion) {
		s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		Categorias nuevo = new Categorias(nombre,descripcion);
		s.save(nuevo);
		tx.commit();
		s.close();
	}
	

}
