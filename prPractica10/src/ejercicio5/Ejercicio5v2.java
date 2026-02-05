package ejercicio5;

import java.util.*;
import java.util.Map.*;

public class Ejercicio5v2 {

	public static void main(String[] args) {

		Map<String, String> dic = new HashMap<>();

		dic.put("Coche", "Car");
		dic.put("Casa", "House");
		dic.put("Hola", "Hello");
		dic.put("LIBRO", "BOOK");
		dic.put("copa", "cup");

		// • Obtén las claves de alguno de los diccionarios que has creado, y almacénalas en un Set.
		Set<String> claves = dic.keySet();
		System.out.println(claves + "\n");

		for (String elem: claves) {
			System.out.println(elem + " - " + dic.get(elem));
		}
		
		System.out.println();
		
		for (Entry<String, String> entrada : dic.entrySet()) {
			System.out.println("Clave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
		}
		
		// • Idem al apartado anterior pero en un conjunto ordenado.
		SortedSet<String> claves2 = new TreeSet<>(dic.keySet());
		System.out.println("\n" + claves2);
		
		// • Crea otra colección con los valores del mapa, por ejemplo, en un LinkedList, y ordénalos.
		
		
	}

}
