package prPractica09;

/**
 * 4.- Manejo de las clases String y StringBuffer:
 */
public class Ejercicio4 {

	sin hacer

	public static void main(String[] args) {

		String vocales = "aeiouAEIOU";

		// Crea un objeto de tipo String que contenga varias palabras
		String obString = new String("Hola que tal");
		System.out.println(obString);

		// Averigua la longitud de la cadena.
		System.out.println("Longitud de la cadena: " + obString.length());
		System.out.println("Hola".length());
		
		// Muestra el carácter que se encuentra en la posición 2 de tu cadena.
		System.out.println("Carácter que se encuentra en la posición 2: " + obString.charAt(1));
		System.out.println("Carácter que se encuentra en la posición 2 (array): " + obString.toCharArray()[1]);
		
		// Mostrar todas las vocales de una cadena.
		System.out.print("Todas las vocales de la cadena: ");
		for (int cont=0;cont<obString.length();cont++) {
			char c = obString.charAt(cont); 
			if (vocales.contains(String.valueOf(c))) {
				System.out.print(c + " ");
			}
		}

		// Extraer la penúltima letra de una cadena.
		System.out.println("\nPenúltima letra de la cadena: " + obString.charAt((obString.length()-2)));

		// Extrae y almacena en otro objeto del mismo tipo toda la cadena excepto los 2 primeros caracteres (subcadena).

		// Extrae y almacena en otro objeto del mismo tipo toda la cadena excepto los 2 primeros caracteres y los dos últimos caracteres.

		// Modifica en la cadena anterior todas las veces que aparezca la vocal ‘a’ (minúscula) por ‘A’ (mayúscula).

		// Crea un array de caracteres cuyos elementos serán los de la cadena anterior.

		// Convierte la subcadena que creaste anteriormente a mayúscula, y que se quede modificada
		// internamente, es decir, no solo a la hora de imprimirla.

		// Comprueba si la cadena empieza por la palabra “Hola”.

		// Busca una subcadena que exista dentro de tu cadena, y otra que no exista (indexOf), recordad que
		// en la cadena original la letra ‘a’ se había cambiado a mayúscula.

		// Busca todas las ocurrencias de una cadena.

		// Extrae de tu cadena la segunda palabra y almacénala en una nueva cadena.

		// A partir de un array de caracteres crea un objeto de tipo cadena.

		// Muestra el valor Unicode de cada uno de los caracteres de la cadena anterior (codePointAt).

		// Crea un objeto de tipo StringBuffer, y prueba diferentes formas de concatenación con el método
		// Append.

		// Insertar al objeto anterior una subcadena, a partir de la posición 7.

		// A partir de un array de tipo byte que contiene números de un dígito, y con la ayuda del método
		// reverse de la clase StringBuffer, invierte el citado array.

	}

}
