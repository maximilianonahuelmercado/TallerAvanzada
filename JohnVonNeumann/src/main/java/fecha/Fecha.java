package fecha;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
	
	public static String sumarFecha(Date fecha, int cantidad, String dato) {
		
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat retfrmt;
		int dat = 0;
		
		if (cantidad == 0)
			return "Es hoy.";
		else if (cantidad > 0)
			retfrmt = new SimpleDateFormat("'Sera el' EEEE dd 'de' MMMM 'de' yyyy");
		else
			retfrmt = new SimpleDateFormat("'Fue el' EEEE dd 'de' MMMM 'de' yyyy");
		
		if (dato.equals("dia"))
			dat = Calendar.DAY_OF_YEAR;
		else if (dato.equals("mes"))
			dat = Calendar.MONTH;
		else if (dato.equals("ani"))
			dat = Calendar.YEAR;
		else
			return retfrmt.format(fecha);
		calendar.setTime(fecha);
		calendar.add(dat, cantidad);
		
		return retfrmt.format(calendar.getTime());
	}

	public static String diasTranscurridos(Date fechaInicial, Date fechaFinal) {
		int dias = (int) (Math.abs((fechaFinal.getTime() - fechaInicial.getTime())) / 86400000);
		return "Pasaron "+dias+" dias.";
	}
	
	public static String fechaHoy() {
		
		return new SimpleDateFormat(" dd-MMMM-yyyy-hh:mma-EEEE ").format(Calendar.getInstance().getTime());
		
	}

	public static String hora() {
		String[] part = fechaHoy().split("-");
		return "Son las "+part[3];
	}
	
	public static String diaDeLaSemana() {
		String[] part = fechaHoy().split("-");
		return "Hoy es "+part[4];
	}
	
	public static String fechaActual() {
		String[] part = fechaHoy().split("-");
		return "Hoy es el"+part[0]+" de "+part[1]+" del "+part[2]+"";
	}
	public static void main(String[] args) {

		/*Date FECHA1 = new GregorianCalendar(2018, 3,30,15,15,0).getTime();
		Date FECHA2 = new GregorianCalendar(2018, 5, 23, 15, 15, 0).getTime();
		Date FECHA_MAS = new GregorianCalendar().getTime();
		int resu = 0;
		int dias = -3;
		String dato="qué día fue hace 3 días?";
		FECHA_MAS = sumarFecha(FECHA_MAS, dias,dato);
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE-dd-MMMM-yyyy");
		
		System.out.println(sdf.format(FECHA_MAS));
	
		resu = diasTranscurridos(FECHA1, FECHA2);
		System.out.println(resu);*/
		
		
		//System.out.println(Fecha.fechaDeHoy());
		
		System.out.println(Fecha.hora());
		System.out.println(Fecha.fechaActual());
		System.out.println(Fecha.diaDeLaSemana());
		
	
	}
}
