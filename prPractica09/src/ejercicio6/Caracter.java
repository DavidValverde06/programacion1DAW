package ejercicio6;

/**
 * Crear la clase Carácter con los dos métodos de clase siguientes:
 * 	• int ordinal(char c): devuelve el valor ascii del carácter c.
 * 	• char ascii(int i): devuelve el carácter correspondiente el valor ascii i.
 */
public class Caracter {

	/**
	 * int ordinal(char c):
	 *  
	 * devuelve el valor ascii del carácter c.
	 */
	public static int ordinal(char c) {
		int valorAscii = c;
		return valorAscii;
	}

	/**
	 * char ascii(int i):
	 * 
	 * devuelve el carácter correspondiente el valor ascii i
	 */
	public static char ascii(int i) {
		char caracter = (char)i;
		return caracter;
	}

	//	public static void main(String[] args) {
	//		int num=65; // Caracter ASCII = 'A'
	//		char caracter='A';
	//		System.out.println(ascii(num));
	//		System.out.println(ordinal(caracter));
	//	}
	
}
