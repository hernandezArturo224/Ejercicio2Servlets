package daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelos.Usuarios;
import utilidades.HibernateUtil;
import utilidades.StringUtilities;
import utilidades.UsoLogger;

import java.util.*;

public class UsuariosDAO {
	
	private static Session s;
	
	public static Usuarios getLoginUser(String email, String clave) {
		s = HibernateUtil.getSessionFactory().openSession();
		
		 String hQuery = " from Usuarios u " +
                 " where u.email = :email";
		 		Usuarios us = s.createQuery(hQuery, Usuarios.class)
                  .setParameter("email", email)
                  .setMaxResults(1)
                  .uniqueResult();
		 		
		 	s.close();	
 		if(us != null) {
 			if(StringUtilities.checkPassword(clave, us.getClave())) {
 				return us;
 			}else {
 				return null;
 			}
 		}else {
 			return null;
 		}	
	}
	
	public static List<Usuarios> getAllUsers(){
		s = HibernateUtil.getSessionFactory().openSession();
		String hQuery = "from Usuarios";
		List<Usuarios> users = s.createQuery(hQuery,Usuarios.class).list();
		s.close();
		return users;
	}
	
	public static boolean compruebaIdExistente(int id) {
		s = HibernateUtil.getSessionFactory().openSession();
		
		 String hQuery = " from Usuarios u " +
                 " where u.id = :id";
		 
		 Usuarios us = s.createQuery(hQuery,Usuarios.class)
				 		.setParameter("id", id)
				 		.setMaxResults(1)
		 				.uniqueResult();
		 
		 s.close();
		 
		 if(us != null) {
			 return true;
		 }else {
			 return false;
		 }
	}
	
	public static boolean compruebaEmailExistente(String email) {
		s = HibernateUtil.getSessionFactory().openSession();
		
		 String hQuery = " from Usuarios u " +
                " where u.email = :email";
		 
		 Usuarios us = s.createQuery(hQuery,Usuarios.class)
				 		.setParameter("email", email)
				 		.setMaxResults(1)
		 				.uniqueResult();
		 
		 s.close();
		 
		 if(us != null) {
			 return true;
		 }else {
			 return false;
		 }
	}
	
	
	public static void insertUser(int id_rol,String email,String clave,String nombre,String ap1, String ap2,String direccion,String localidad,String provincia,String telefono,String dni ) {
		s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		Usuarios nuevo = new Usuarios(id_rol,email,clave,nombre,ap1,ap2,direccion,localidad,provincia,telefono,dni);
		s.save(nuevo);
		tx.commit();
		s.close();
	}
}
