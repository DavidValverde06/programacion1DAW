package clasesString;

import java.nio.charset.Charset;

public class TestString {

	public static void main(String[] args) {
		
		// Formas de crear cadenas
		String str1 = "Hola";              // Forma más eficiente de crear un String
		String str2 = new String("Hola");  // Creación explícita usando un constructor
		
		char[] caracteres = {'H', 'o', 'l', 'a'};
		String str3 = new String(caracteres);  // Constructor que recibe un array de caracteres
		System.out.println(str3);
		
		byte[] datos = {97,98,99}; 
		String codificada = new String (datos, Charset.defaultCharset()); 
					// charset.defaultCharset() - Devuelve el conjunto de caracteres 
					// predeterminado del sistema (generalmente UTF-8).
		System.out.println(codificada);  // Mostrará abc
		
		// Manejo de métodos
		String s1 = "Hola";
		String s2 = s1.concat(" Mundo");  // Se crea un nuevo objeto "Hola Mundo"
		System.out.println(s1);           // Imprime "Hola" (s1 no se modifica)
		System.out.println(s2);           // Imprime "Hola Mundo"

		String s3 = s2.toUpperCase(); // De nuevo devuelve un nuevo objeto
		System.out.println(s3);
		
		s2.toUpperCase();  // En este caso, esta sentencia no tendría el efecto esperado, ya que
		                   // nos devuelve la cadena convertida a mayúscula pero no se ha hecho
						   // nada con el valor devuelto
		System.out.println(s2);
		
		System.out.println(s1.length());
		System.out.println("Hola que tal".length());
		System.out.println("Hola que tal".toUpperCase());
		
		
		String texto2 = "Este es un texto que ocupa " + 
						"varias líneas, no obstante se puede " + 
						"perfectamente encadenar";
		System.out.println(texto2);

		System.out.println("Año".equals("Año"));
		System.out.println("Año".equalsIgnoreCase("AÑO"));
		System.out.println("ana".compareTo("bobo"));
		System.out.println("bobo".compareTo("ana"));
		System.out.println("ana".compareTo("aña"));

	}

}
