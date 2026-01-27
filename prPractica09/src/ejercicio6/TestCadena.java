package ejercicio6;

/**
 * Hacer una clase para probar la clase Cadena.
 */
public class TestCadena {

	public static void main(String[] args) {

		Cadena miCadena = new Cadena("Hola que tal estas");

		// Visualizar cadena
		System.out.println("Visualizar la cadena: ");
		System.out.println(miCadena.visualizaCadena());

		// Invertir cadena
		System.out.println("\nInvertir la cadena: ");
		miCadena.invierteCadena();
		System.out.println(miCadena.visualizaCadena());
		miCadena.invierteCadena();
		
		// Encriptar cadena
		System.out.println("\nEncriptar la cadena: ");
		miCadena.encriptaCadena();
		System.out.println(miCadena.visualizaCadena());
		
		// Desencriptar cadena
		System.out.println("\nDesencriptar la cadena: ");
		miCadena.desencriptaCadena();
		System.out.println(miCadena.visualizaCadena());

	}

}
