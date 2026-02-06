package ejercicio5;

import java.util.*;
import java.util.Map.*;

public class Ejercicio5v2 {

	public static void main(String[] args) {

		Map<String, String> dic = new HashMap<>();

		dic.put("coche", "car");
		dic.put("casa", "house");
		dic.put("hola", "hello");
		dic.put("LIBRO", "BOOK");
		dic.put("copa", "cup");

		System.out.println(dic + "\n");

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

		// Obtener las claves en un conjunto ordenado sin distinguir entre mayus y minus, en el constructor de la nueva
		// coleccion especificare la forma de ordenar con la ayuda de Comparator
		SortedSet<String> clavesOrden2 = new TreeSet<String>((o1,o2) -> o1.compareToIgnoreCase(o2));

		clavesOrden2.addAll(dic.keySet());
		System.out.println("\nOrdenación ignorando mayus y minus: " + clavesOrden2);


		// • Crea otra colección con los valores del mapa, por ejemplo, en un LinkedList, y ordénalos.
		LinkedList<String> valores = new LinkedList<>(dic.values());
		System.out.println(valores);

		valores.sort(null);

		//Para poder ordenar el objeto tipo Collection, ha habido que convertirlo
		//en un objeto tipo List, concretamente en este ejemplo ArrayList
		List<String> valores2 = new ArrayList<String>(valores);
		Collections.sort(valores2);
		System.out.println(valores2);

		Collection<String> valores3 = new LinkedList<>(dic.values());
		System.out.println(valores3);
	}

}
