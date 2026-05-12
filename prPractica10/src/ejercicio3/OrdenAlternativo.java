package ejercicio3;

import java.util.*;

public class OrdenAlternativo implements Comparator<Libro>{
	
	@Override
	public int compare(Libro o1, Libro o2) {
		
		int compara = o1.getAutor().compareTo(o2.getAutor());

        if (compara != 0) {
            return compara; // Son distintos
        } else {
            return o2.getTitulo().compareTo(o1.getTitulo()); // Autores iguales, devuelvo titulos
        }
	}

}
