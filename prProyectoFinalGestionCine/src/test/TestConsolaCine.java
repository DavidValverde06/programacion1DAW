package test;

import fechas.*;
import modelo.*;

public class TestConsolaCine {

	public static void main(String[] args) {

		Pelicula peliculaInterstellar = new Pelicula(1,"Interstellar", EnumGenero.CIENCIA_FICCION,
				169, EnumClasificacion.CLASIFICACION_12, "Christopher Nolan", 2014);

		Sala sala1 = new Sala(1, 50, EnumTipoSala.SALA_NORMAL);

		Sesion sesion1 = new Sesion(LibFechas8.convierteStringToLocalDate("12/05/2026"), 17, 7.00);

		System.out.println(peliculaInterstellar+"\n");
		System.out.println(sala1+"\n");
		System.out.println(sesion1);
	}

}
