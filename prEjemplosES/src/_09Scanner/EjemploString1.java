package _09Scanner;

import java.util.Scanner;

/**
 * El siguiente ejemplo muestra como podemos crear objetos Scanner asociados a objetos
 * tipo String
 * 
 *
 */
public class EjemploString1 {

	public static void main(String[] args) {
		String cad = "";
		
		try (Scanner sc = new Scanner("hola a ; todos. como-estas-adios;fin")) {
			sc.useDelimiter("[ .,;-]+");
			
			while (sc.hasNext()) {
				cad = sc.next();
				System.out.println(cad);
			}
			
//			while (sc.hasNextLine()) {  // Asi solo nos leeria una linea
//				cad = sc.nextLine();
//				System.out.println(cad);
//			} 
		}
	}
}
