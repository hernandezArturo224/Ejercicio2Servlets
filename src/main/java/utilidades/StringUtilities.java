package utilidades;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringUtilities {
	
	public static Timestamp getTimestampFromString(String fecha) {
			
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = new Date();
		try {
			date = format.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Timestamp fecha_bajaFi = new Timestamp(date.getTime());
		
		return fecha_bajaFi;
		
	}
	
	public static Timestamp getDefaultTimestamp() {
		Date date = new Date();
		Timestamp def = new Timestamp(date.getTime());
		return def;
	}

}
