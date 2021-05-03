package daos;

import org.hibernate.Session;

import utilidades.HibernateUtil;
import utilidades.Util;
import modelos.*;

import java.sql.Timestamp;
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
		
		//System.out.println(ProductosDAO.getAllProductos(s).get(0).toString());
		/*GregorianCalendar cal = new GregorianCalendar(2024,10,20);
		Date date = new Date(cal.getTimeInMillis());
		
		
		Timestamp fechaBaja = new Timestamp(date.getTime());
		System.out.println(fechaBaja);
		
		ProductosDAO.insertProducto(s, 1, "Casio", "Casio", 15.0, 15, null, 15f);*/
		
		/*Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el e-mail\n");
		String email = scan.next();
		System.out.println("Introduce la clave\n");
		String clave = scan.next();
		
		scan.close();
		
		Usuarios us = UsuariosDAO.getLoginUser(email, clave);
		if(us != null) {
			System.out.println("Bienvenido "+us.getNombre()+" "+us.getApellido1()+" "+us.getApellido2());
		}else {
			System.out.println("Error de usuario");
		}*/
		
		Provincias[] prov = Util.getProvincias();
		for(Provincias provincia: prov) {
			System.out.println(provincia.getNm());
		}
	}

}
