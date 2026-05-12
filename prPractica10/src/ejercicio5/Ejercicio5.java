package ejercicio5;

import java.util.*;

/**
 * 5.- Realiza pruebas con los Map (mapas o diccionarios), por ejemplo:
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		// • Crear varios diccionarios con las clases LinkedHashMap y HashMap, con palabras en español/inglés.

		// -------------------------------------------------------------
		// Creacion de varios mapas HashMap y LinkedHashMap
		// -------------------------------------------------------------

		Map<String, String> dic = new HashMap<>();
		Map<String, String> dic2 = new LinkedHashMap<>();

		dic.put("Coche", "Car");
		dic.put("Casa", "House");
		dic.put("Hola", "Hello");
		dic.put("LIBRO", "BOOK");
		dic.put("copa", "cup");

		dic2.put("Coche", "Car");
		dic2.put("Casa", "House");
		dic2.put("Hola", "Hello");
		dic2.put("LIBRO", "BOOK");
		dic2.put("copa", "cup");

		System.out.println("HashMap");
		System.out.println(dic);

		System.out.println("\nLinkedMap");
		System.out.println(dic2);

		System.out.println("\nTraducción de casa: " + dic.get("Casa"));
		System.out.println("Traducción de libro: " + dic2.get("LIBRO"));

		// • Crea un mapa a partir de otro ya creado, por ejemplo un TreeSet, a partir de un HashMap, o bien con la
		// ayuda del método putAll.
		System.out.println("\nCreación de un mapa a partir de otro mapa ya creado");
		SortedMap<String, String> dic3 = new TreeMap<>(dic); // Creamos la colección a través del constructor
		SortedMap<String, String> dic4 = new TreeMap<>();

		dic4.putAll(dic);

		System.out.println(dic3);

		System.out.println(dic4);

		dic4.put("Mesa", "Table");
		dic4.put("Rojo", "Red");
		dic4.put("Rosa", "Pink");
		dic4.put("Verde", "Green");

		// Si añadimos un elemento repetido nos devuelve el value anterior,
		// y modifica el value con el nuevo valor
		// 
		if (dic4.put("copa", "cup").equals("cup")) { // Elemento repetido
			System.out.println("\nClave repetida");
		}
		else {
			System.out.println("\nElemento añadido");
		}

		System.out.println("\n" + dic4);

		// • Prueba a crear un diccionario donde las claves estén ordenadas de forma inversa, prueba con clases
		// anónimas y con expresiones lambda.

		
		// Versión 1 | CLASE EXTERNA que implementa una interfaz
		SortedMap<String, String> dic5 = new TreeMap<>(new OrdenaStringDescendente());
		dic5.putAll(dic4);
		System.out.println("\nDiccionario 5 (orden descendente): " + dic5);

		
		// Versión 2 | CLASE ANONIMA
		SortedMap<String, String> dic6 = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				return o2.compareTo(o1);

			} // end Método compare
		} // end Clase Anónima
				); // paréntesis de cierre del método sort

		dic6.putAll(dic4);
		System.out.println("\nDiccionario 6 (orden descendente): " + dic6);


		// Versión 3 | Expresiones Lambda 
		SortedMap<String, String> dic7 = new TreeMap<>((String o1, String o2) ->

		{return o2.compareTo(o1);}
				);

		dic7.putAll(dic4);
		System.out.println("\nDiccionario 7 (orden descendente): " + dic7);


		// Versión 4 | Expresiones Lambda v2 (más corto)
		SortedMap<String, String> dic8 = new TreeMap<>((o1, o2) -> o2.compareTo(o1));

		dic8.putAll(dic4);
		System.out.println("\nDiccionario 8 (orden descendente): " + dic8);

	}

}
