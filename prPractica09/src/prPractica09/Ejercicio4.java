package prPractica09;

import java.util.Arrays;

/**
 * 4.- Manejo de las clases String y StringBuffer:
 */
public class Ejercicio4 {


	public static void main(String[] args) {

		String vocales = "aeiouAEIOU";
		String otraCadena;

		// Crea un objeto de tipo String que contenga varias palabras
		String obString = "Tiene la Tarara un vestido blanco que sólo se pone en el Jueves Santo.";
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
		// otraCadena=obString.substring(2,obString.length());

		otraCadena=obString.substring(2);
		System.out.println(otraCadena);

		// Extrae y almacena en otro objeto del mismo tipo toda la cadena excepto los 2 primeros caracteres y los dos últimos caracteres.
		otraCadena=obString.substring(2,obString.length()-2);
		System.out.println(otraCadena);

		// Modifica en la cadena anterior todas las veces que aparezca la vocal ‘a’ (minúscula) por ‘A’ (mayúscula).
		System.out.println(otraCadena=otraCadena.replace('a', 'A'));

		// Crea un array de caracteres cuyos elementos serán los de la cadena anterior.
		char[] arrayCaracteres = obString.toCharArray();
		for(int cont=0;cont<arrayCaracteres.length;cont++) {
			System.out.print(arrayCaracteres[cont]);
		}
		System.out.println();

		// Convierte la subcadena que creaste anteriormente a mayúscula, y que se quede modificada
		// internamente, es decir, no solo a la hora de imprimirla.
		System.out.println(otraCadena=otraCadena.toUpperCase());

		// Sacar la palabra "blanco" a un array con el método getChars y substring
//		try {
//			int longitudPalabra="blanca".length();
//			char[] array3 = new char[longitudPalabra];
//			
//			int posicionPalabra=obString.indexOf("blanca");
//			
//			obString.getChars(posicionPalabra, posicionPalabra+longitudPalabra, array3, 0);
//			System.out.println(Arrays.toString(array3));
//			
//			char[] array4 = obString.substring(posicionPalabra,posicionPalabra+longitudPalabra)
//		}
//		catch (StringIndexOutOfBoundsException e) {
//			
//		}

		// Comprueba si la cadena empieza por la palabra “Hola”.
		System.out.println(obString.startsWith("Hola"));
		System.out.println(obString.startsWith("La tarara"));
		System.out.println(obString.toUpperCase().startsWith("La tarara".toUpperCase()));

		// Busca una subcadena que exista dentro de tu cadena, y otra que no exista (indexOf), recordad que
		// en la cadena original la letra ‘a’ se había cambiado a mayúscula.
		System.out.println();
		System.out.println(obString);
		System.out.println(obString.indexOf("un vestido blanco"));
		System.out.println(obString.indexOf("un vestido nigga"));
		
		// Busca todas las ocurrencias de una cadena.
		 
		
		// Extrae de tu cadena la segunda palabra y almacénala en una nueva cadena.
//		System.out.println("\n");
//		
//		String nuevaCadena;
//		String[] arrayCaracteresSplit;
//		
//		arrayCaracteresSplit = obString.split(" ,.:;");
//		System.out.println(Arrays.toString(arrayCaracteresSplit));
//		System.out.println("Segunda palabra: " + arrayCaracteresSplit[1]);
		
		
		// A partir de un array de caracteres crea un objeto de tipo cadena.
		
		char[] arrayCaracteres2 = {'H','o','l','a'};
		String cadena2="";
		
		for (int cont=0;cont<arrayCaracteres2.length;cont++) {
			cadena2+=arrayCaracteres2[cont];
		}
		
		System.out.println(cadena2);
		
		// Muestra el valor Unicode de cada uno de los caracteres de la cadena anterior (codePointAt).

		
		
		// Crea un objeto de tipo StringBuffer, y prueba diferentes formas de concatenación con el método
		// Append.

		// Insertar al objeto anterior una subcadena, a partir de la posición 7.

		// A partir de un array de tipo byte que contiene números de un dígito, y con la ayuda del método
		// reverse de la clase StringBuffer, invierte el citado array.

	}

}
