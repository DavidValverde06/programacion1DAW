package prPractica02;

import java.util.Scanner;

/**
 * 5. En una partida de un determinado juego, según los puestos conseguidos se obtiene un grado u otro,
	  siguiendo la siguiente tabla:
 */

public class Ejercicio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int puntos;
		
		System.out.print("Introduce tus puntos: ");
		puntos=sc.nextInt();
		
		if (puntos<60) {
			System.out.println("Grado E");
		}
		else if (puntos>=60 && puntos <=69) {
			System.out.println("Grado D");
		}
		else if (puntos>=70 && puntos <=79) {
			System.out.println("Grado C");
		}
		else if (puntos>=80 && puntos <=89) {
			System.out.println("Grado B");
		}
		else if (puntos>=90) {
			System.out.println("Grado A");
		}
		else {
			System.out.println("Puntuación no válida");
		}
		
		sc.close();
	}

}
