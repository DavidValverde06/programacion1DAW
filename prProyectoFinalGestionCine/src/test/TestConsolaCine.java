package test;

import modelo.EnumClasificacion;
import modelo.EnumGenero;
import modelo.Pelicula;

public class TestConsolaCine {

	public static void main(String[] args) {

		Pelicula peliculaInterstellar = new Pelicula("Interstellar", EnumGenero.CIENCIA_FICCION,
				169, EnumClasificacion.CLASIFICACION_12, "Christopher Nolan", 2014);
		
		System.out.println(peliculaInterstellar);
	}

}
