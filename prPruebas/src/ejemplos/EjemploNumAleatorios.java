package ejemplos;

import java.util.Random;

public class EjemploNumAleatorios {

	public static void main(String[] args) {

		// ---------------------------------------------------------------
		// Generacion de num aleatorios con la Clase Random
		// ---------------------------------------------------------------

		int num;

		Random random = new Random();

		// Generar un num aleatorio entre 0 y 40

		System.out.println(random.nextInt(41));

		// Generar un num aleatorio entre 1 y 40

		System.out.println(random.nextInt(40)+1);

		System.out.println(); // Salto de linea

		// Generar caras de un dado (1 hasta 6)

		num=random.nextInt(6)+1;

		System.out.println(num);

		if (num==1) {
			System.out.println("Ha salido un uno");
		}
		else {
			System.out.println("No ha salido un uno");
		}

		System.out.println();

		// ------------------------------------------------------------------------------------------
		// Generacion de num aleatorios con el método random de la clase Math (Math.random)
		// ------------------------------------------------------------------------------------------

		// Generar un num aleatorio entre 0 y 40

		System.out.println((int)(Math.random()*41));

		// Generar un num aleatorio entre 1 y 40

		System.out.println((int)(Math.random()*40)+1);

		System.out.println(); // Salto de linea

		// Generar caras de un dado (1 hasta 6)

		num=(int)(Math.random()*6)+1;

		System.out.println(num);

		if (num==1) {
			System.out.println("Ha salido un uno");
		}
		else {
			System.out.println("No ha salido un uno");
		}
	}

}
