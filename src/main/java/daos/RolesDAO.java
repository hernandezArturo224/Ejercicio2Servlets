package daos;

import modelos.Roles;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class RolesDAO {
	
	public static List<Roles> getAllRoles(Session s) {
		String hQuery = "from Roles";
		List<Roles> roles = s.createQuery(hQuery,Roles.class).list();
		
		return roles;
	}
	
	public static boolean getIdExistente(Session s, int id) {
		String hQuery = "from Roles r" + " where r.id = :id";
		Roles nuevo = s.createQuery(hQuery,Roles.class)
						.setParameter("id", id)
						.setMaxResults(1)
						.uniqueResult();
		
		if(nuevo != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void insertRol(Session s, int id, String rol) {
		Transaction tx = s.beginTransaction();
		Roles nuevo = new Roles(id,rol);
		s.save(nuevo);
		tx.commit();
	}

}
