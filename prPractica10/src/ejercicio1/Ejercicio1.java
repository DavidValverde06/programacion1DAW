package ejercicio1;

import java.util.*;

/**
 * 1.- Crear una colección tipo Collection, en la colección vamos a guardar de todo un poco, así que la
 * parametrizaremos a Object. A continuación, realiza las siguientes acciones sobre este objeto:
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Collection<Object> lista = new ArrayList<Object>();
		
		// Añade varios elementos a tu colección: varias cadenas, varios números
		// (con y sin decimales), un objeto Random, varios objetos Libro.
		
		lista.add("Hola");
		lista.add("Adios");
		lista.add(20);
		lista.add(3.14);
		lista.add(Random);
		lista.add(new Libro("", "", true));
		lista.add(new Libro(null, null, false));
		lista.add(new Libro(null, null, false));
	}

}
