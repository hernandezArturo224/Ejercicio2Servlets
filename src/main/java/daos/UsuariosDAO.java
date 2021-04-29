package daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelos.Usuarios;
import utilidades.UsoLogger;

import java.util.*;

public class UsuariosDAO {
	
	public static Usuarios getLoginUser(Session s,String email, String clave) {
		 String hQuery = " from Usuarios u " +
                 " where u.email = :email";
		 		Usuarios us = s.createQuery(hQuery, Usuarios.class)
                  .setParameter("email", email)
                  .setMaxResults(1)
                  .uniqueResult();
 		if(us != null) {
 			if(us.getClave().equals(clave)) {
 				return us;
 			}else {
 				return null;
 			}
 		}else {
 			return null;
 		}	
	}
	
	public static boolean compruebaIdExistente(Session s,int id) {
		 String hQuery = " from Usuarios u " +
                 " where u.id = :id";
		 
		 Usuarios us = s.createQuery(hQuery,Usuarios.class)
				 		.setParameter("id", id)
				 		.setMaxResults(1)
		 				.uniqueResult();
		 
		 if(us != null) {
			 return true;
		 }else {
			 return false;
		 }
	}
	
	public static boolean compruebaEmailExistente(Session s,String email) {
		 String hQuery = " from Usuarios u " +
                " where u.email = :email";
		 
		 Usuarios us = s.createQuery(hQuery,Usuarios.class)
				 		.setParameter("email", email)
				 		.setMaxResults(1)
		 				.uniqueResult();
		 
		 if(us != null) {
			 return true;
		 }else {
			 return false;
		 }
	}
	
	
	public static void insertUser(Session s, int id,int id_rol,String email,String clave,String nombre,String ap1, String ap2,String direccion,String localidad,String provincia,String telefono,String dni ) {
		Transaction tx = s.beginTransaction();
		Usuarios nuevo = new Usuarios(id,id_rol,email,clave,nombre,ap1,ap2,direccion,localidad,provincia,telefono,dni);
		s.save(nuevo);
		tx.commit();
	}
}
