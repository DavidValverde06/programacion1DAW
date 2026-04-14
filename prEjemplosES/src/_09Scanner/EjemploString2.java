package _09Scanner;

import java.util.Scanner;

/**
 * En este ejemplo tambien utilizaremos un objeto Scanner para sacar los datos
 * de varias personas que tenemos guardados en un objeto String. 
 * 
 * Cada linea (\n) contienen el nombre, dni y la edad de una persona, separados por , ; - (por uno de estos)
 * 
 */

public class EjemploString2 {

	public static void main(String[] args) {
		String datos = "Manuel García - 1212121M, 23\nAlicia Gómez, 232123123K, 32\n"
				+ "Luis Moreno, 12111222L - 19\nMarina Gallardo - 99922200P-29\n";

		String nombre = "", dni = "";
		int edad = 0;

		try (Scanner sc1 = new Scanner(datos)) {

			while (sc1.hasNextLine()) { 
				String linea = sc1.nextLine();

				try (Scanner sc2 = new Scanner(linea).useDelimiter("\\s*[,:-]\\s*")) {

					nombre = sc2.next();
					dni = sc2.next();
					edad = sc2.nextInt();

					Persona p = new Persona(nombre, dni, edad);
					System.out.println(p);

				} // end try sc2
			} // end while
		} // end try sc1

	}

}
