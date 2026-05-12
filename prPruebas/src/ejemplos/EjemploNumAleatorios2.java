package ejemplos;

import java.util.Random;
/**
 * Clase para probar la generación de números aleatorios
 * Podemos usar para generar aleatorios:
 *
 * - Método random de la clase Math (método de clase)
 *
 * - Clase Random que tiene varios métodos de objeto para generar
 * números aleatorios, entre ellos el método nextInt
 *
 * @author profesor
 *
 */
public class EjemploNumAleatorios2 {
	public static void main(String[] args) {

		// ----------------------------------------------------------
		// Prueba del método random de la clase Math
		// ----------------------------------------------------------

		double numero;

		numero = Math.random();

		System.out.println("Número aleatorio: "+numero);

		// Generar un número entre 1 y 10
		System.out.println("Número aleatorio entre 1 y 10: "+
				(int) Math.floor(Math.random()*10+1));

		// Generar valores entre 10 y 30
		System.out.println("Número aleaotorio entre 10 y 30: "+
				(int) Math.floor(Math.random()*21+10));

		// Generar valores entre 12 y 20
		System.out.println("Número aleaotorio entre 12 y 20: "+
				(int) Math.floor(Math.random()*9+12));

		// Generar las caras de un dado
		System.out.println("Dado: "+(int) Math.floor(Math.random()*6+1));


		// ----------------------------------------------------------
		// Prueba del la clase Random
		// ----------------------------------------------------------

		// Crear un objeto de la clase Random
		Random obRandom = new Random();

		// Generar un número aleatorio entre 1 y 20
		int numero2 = obRandom.nextInt(20); // Genera un valor entre 0..19

		numero2++; // Número entre 1 y 20

		System.out.println("Número entre 1 y 20: "+numero2);

		// Simular una cara de un dado
		System.out.println("Dado: "+(obRandom.nextInt(6)+1));

		// Simular la cara de un dado (ERRONEAMENTE)
		int dado = obRandom.nextInt(7); // Genera valores entre 0 y 6
		System.out.println(dado);
		
		// OJO QUE LA CARA 0 DEL DADO NO EXISTE


		// Generar valores entre 10 y 30
		System.out.println("Número aleatorio entre 10 y 30: "+(obRandom.nextInt(21)+10));

		// Generar valores entre 12 y 20
		System.out.println("Número aleaotorio entre 12 y 20: "+(obRandom.nextInt(9)+12));

		// Simular el lanzamiento de una moneda
		if (obRandom.nextInt(2)==0) // Cara
			System.out.println("Cara");
		else
			System.out.println("Cruz");

		if (obRandom.nextBoolean()==true) // Verdadero lo igualo a cara
			System.out.println("Cara");
		else
			System.out.println("Cruz");

		if (obRandom.nextBoolean()) // Verdadero lo igualo a cara
			System.out.println("Cara");
		else
			System.out.println("Cruz");
	}
}
