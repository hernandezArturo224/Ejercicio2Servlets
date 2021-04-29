package daos;

import org.hibernate.Session;

import utilidades.HibernateUtil;
import modelos.Usuarios;

public class pruebaDaos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		/*Usuarios us= UsuariosDAO.getLoginUser(s, "admin@tiendaonline.es", "1234");
		System.out.println(us.toString());*/
		
		
		
		//UsuariosDAO.insertUser(s,4,3,"arturohernande1@usal.es","1234","arturituri",null,null,null,null,null,null,null );
		
		//System.out.println(UsuariosDAO.compruebaIdExistente(s, 5));
	}

}
