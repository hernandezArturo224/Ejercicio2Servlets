package daos;

import org.hibernate.Session;

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
}
