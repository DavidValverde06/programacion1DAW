package cualquierVersion;

import java.util.*;

public class TestLibreriaFechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar fecha1 = new GregorianCalendar(2019, 1, 18);
		System.out.println(LibreriaFechas.getFechaFull(fecha1));
		
		LibreriaFechas.setDia(fecha1, 40);
		System.out.println(LibreriaFechas.getFechaFull(fecha1));
		
		LibreriaFechas.setMes(fecha1, 5);
		LibreriaFechas.setAño(fecha1, 2015);
		System.out.println(LibreriaFechas.getFechaFull(fecha1));
		
		LibreriaFechas.sumaDias(fecha1, 1000);
		System.out.println(LibreriaFechas.getFechaFull(fecha1));
		
		Calendar fecha2 = LibreriaFechas.copiaFecha(fecha1);
		Calendar fecha3 = LibreriaFechas.copiaFecha2(fecha1);
		
		LibreriaFechas.setDia(fecha1, 10);
		LibreriaFechas.setDia(fecha2, 11);
		LibreriaFechas.setDia(fecha3, 12);
		
		System.out.println(LibreriaFechas.getFechaFull(fecha1));
		System.out.println(LibreriaFechas.getFechaFull(fecha2));
		System.out.println(LibreriaFechas.getFechaFull(fecha3));
		
		Calendar fecha4 = new GregorianCalendar(2019, 1, 18);
		Calendar fecha5 = new GregorianCalendar(2019, 1, 30);
		System.out.println("\n"+LibreriaFechas.getFechaFull(fecha4));
		System.out.println(LibreriaFechas.getFechaFull(fecha5));
		System.out.println(LibreriaFechas.getRestaFechas(fecha5, fecha4));
		
		System.out.println(LibreriaFechas.esFechaCorrecta("12/03/2019"));
		System.out.println(LibreriaFechas.esFechaCorrecta("42/03/2019"));
		System.out.println(LibreriaFechas.esFechaCorrecta("1/02/2024"));
		System.out.println(LibreriaFechas.esFechaCorrecta("cxvzxv"));
		
	}

}




