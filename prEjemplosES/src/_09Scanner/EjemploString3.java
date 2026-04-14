package _09Scanner;

import java.util.Scanner;

/**
 * En este ejemplo tambien utilizaremos un objeto Scanner para sacar los datos
 * de varias personas que tenemos guardados en un objeto String. 
 * 
 * En este caso los datos de las personas se especifican en lineas (separadas por .)
 * Cada l�nea el nombre, dni y la edad de una persona, separados por , ; - (por uno de estos)
 * 
 */

public class EjemploString3 {

	public static void main(String[] args) {
		String datos = "Manuel García - 1212121M, 23.Alicia Gómez, 232123123K, 32."
				+ "Luis Moreno, 12111222L - 19.Marina Gallardo - 99922200P-29.";

		try (Scanner sc1 = new Scanner(datos).useDelimiter("[.]")) {

			while (sc1.hasNext()) {  // Hemos cambiado hasNextLine y por hasNext al tener el punto 
				                     // como caracter de separcion de tokens
				String linea = sc1.next();   // Hemos cambiado nextLine y por next

				try (Scanner sc2 = new Scanner(linea).useDelimiter("\\s*[,:-]\\s*")) {

					Persona p = new Persona(sc2.next(), sc2.next(), sc2.nextInt());
					System.out.println(p);

				} // end try sc2
			} // end while
		} // end try sc1

	}

}
