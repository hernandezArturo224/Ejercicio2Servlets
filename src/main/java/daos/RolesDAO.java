package daos;

import modelos.Roles;
import utilidades.HibernateUtil;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class RolesDAO {
	private static Session s;
	
	public static List<Roles> getAllRoles() {
		s = HibernateUtil.getSessionFactory().openSession();
		String hQuery = "from Roles";
		List<Roles> roles = s.createQuery(hQuery,Roles.class).list();
		s.close();
		return roles;
	}
	
	public static boolean getIdExistente( int id) {
		s = HibernateUtil.getSessionFactory().openSession();
		String hQuery = "from Roles r" + " where r.id = :id";
		Roles nuevo = s.createQuery(hQuery,Roles.class)
						.setParameter("id", id)
						.setMaxResults(1)
						.uniqueResult();
		
		s.close();
		
		if(nuevo != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void insertRol( int id, String rol) {
		s=HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		Roles nuevo = new Roles(id,rol);
		s.save(nuevo);
		tx.commit();
		s.close();
	}

}
