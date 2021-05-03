package controllers;

import java.sql.Timestamp;

import daos.ProductosDAO;
import utilidades.StringUtilities;

public class ProductosController {

	public static boolean insertProductoControl(String id_cat,String fecha,String sto,String imp,String pre,String descripcion,String nombre) {
		boolean correcto= true;
		
		int id_categoria=0;
		if(id_cat.equals("")) {
			correcto = false;
		}else {
			id_categoria = Integer.parseInt(id_cat);
		}
		
		Timestamp fecha_baja = StringUtilities.getDefaultTimestamp();
		if(fecha.equals("")) {
			correcto = false;
		}else {
			fecha_baja = StringUtilities.getTimestampFromString(fecha);
		}
		
		int stock=50;
		if(sto.equals("")) {
			//correcto = false;
		}else {
			stock = Integer.parseInt(sto);
		}
		
		float impuesto=21;
		if(imp.equals("")) {
			//correcto = false;
		}else {
			impuesto = Float.parseFloat(imp);
		}
		
		double precio=50.5;
		if(pre.equals("")) {
			//correcto = false;
		}else {
			precio = Double.parseDouble(pre);
		}
		
		if(correcto) {
			ProductosDAO.insertProducto(id_categoria, nombre, descripcion, precio, stock, fecha_baja, impuesto);
		}else {
			correcto = false;
		}
		
		return correcto;
		
	}
}
