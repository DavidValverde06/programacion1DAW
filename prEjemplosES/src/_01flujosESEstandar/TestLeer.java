package _01flujosESEstandar;

/**
 * Clase que permite testear algunos de los métodos de la clase Leer
 *
 */
public class TestLeer {

	public static void main(String[] args) {
		
		int varInt;
		float varFloat;
		String cadena;
		char caracter;
		
		System.out.println("Número entero: ");
		varInt = Leer.leeInt();
		System.out.println(varInt);
		
		System.out.println("Carácter: ");
		caracter = Leer.leeChar();
		System.out.println(caracter);

		System.out.println("Número real: ");
		varFloat = Leer.leeFloat();
		System.out.println(varFloat);
		
		System.out.println("Cadena: ");
		cadena = Leer.leeCadena();
		System.out.println(cadena);
	
	}

}
