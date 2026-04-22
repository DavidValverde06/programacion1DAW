package ejercicio4;

import java.util.*;

public class Prueba {

	public static void main(String[] args) {

		// Dos formas de guardar un array en una colección
		List<String> listaDias = Arrays.asList(new String[] {"Lunes","Martes","Miércoles","Jueves","Viernes","Fin de semana"});
		List<String> listaDias2 = Arrays.asList("Lunes","Martes","Miércoles","Jueves","Viernes","Sabado","Domingo");

		System.out.println(listaDias);
		System.out.println(listaDias2);
	}

}
