package controllers;

import daos.UsuariosDAO;
import utilidades.StringUtilities;

public class RegistroController {
	
	public static boolean insertUserControl(String idrstr,String email,String clavePass,String nombre,String ap1,String ap2,String direccion, String localidad, String provincia, String telefono, String dni) {
		boolean correcto = true;
			int id_rol=0;
			if(idrstr.equals("")) {
				correcto = false;
			}else {
				id_rol = Integer.parseInt(idrstr);
			}
			
			if(email.equals("")) {
				correcto = false;
			}
			
			String clave=StringUtilities.getEncryptedPassword("contrasena"); //clave por defecto
			if(clavePass.equals("")) {
				correcto = false;
			}else {
				clave = StringUtilities.getEncryptedPassword(clavePass);
			}
		
			
			if(correcto) {
				UsuariosDAO.insertUser(id_rol, email, clave, nombre, ap1, ap2, direccion, localidad, provincia, telefono, dni);
			}
			
		
		return correcto;
	}

}
