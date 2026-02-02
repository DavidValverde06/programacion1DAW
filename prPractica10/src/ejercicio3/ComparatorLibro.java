package ejercicio3;

import java.util.*;

public class ComparatorLibro implements Comparator<Libro>{
	
	@Override
	public int compare(Libro o1, Libro o2) {
		
		int resultadoAutor = o1.getAutor().compareTo(o2.getAutor());

        if (resultadoAutor != 0) {
            return resultadoAutor; // Son distintos
        } else {
            return o1.getTitulo().compareTo(o2.getTitulo()); // Autores iguales, devuelvo titulos
        }
	}

}
