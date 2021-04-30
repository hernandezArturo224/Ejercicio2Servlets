package daos;

import org.hibernate.Session;

import utilidades.HibernateUtil;
import modelos.*;
import java.util.*;

public class pruebaDaos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		/*Usuarios us= UsuariosDAO.getLoginUser(s, "admin@tiendaonline.es", "1234");
		System.out.println(us.toString());*/
		
		
		
		//UsuariosDAO.insertUser(s,4,3,"arturohernande1@usal.es","1234","arturituri",null,null,null,null,null,null,null );
		
		//List<Roles> roles= RolesDAO.getAllRoles(s);
		
		//System.out.println(roles.get(1).toString());
		
		//RolesDAO.insertRol(s, 4, "Observador");
		
		//System.out.println(CategoriasDAO.getAllCategorias(s).get(1).toString());
		//CategoriasDAO.insertCategoria(s, "Mandiles", "Mandiles wapisimos");
	}

}
