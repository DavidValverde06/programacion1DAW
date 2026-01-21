package claseMath;

import java.util.Random;

/**
 * Clase para probar la generaci�n de n�meros aleatorios 
 * 
 * Podemos usar para generar aleatorios:
 * 
 *   - Método random de la clase Math (método de clase)
 *   
 *   - Clase Random que tiene varios métodos de objeto para generar
 *     n�meros aleatorios, entre ellos el método nextInt 
 *   
 * 
 * @author profesor
 *
 */

public class TestAleatorios {

	public static void main(String[] args) {
		
		// ----------------------------------------------------------
		// Prueba del método random de la clase Math
		// ----------------------------------------------------------
		double numero;
		
		numero = Math.random();
		
		System.out.println("N�mero aleatorio: "+numero);
		
		// Generar un n�mero entre 1 y 10
		System.out.println("N�mero aleatorio entre 1 y 10: "+ (int) Math.floor(Math.random()*10+1));
		
		// Generar valores entre 10 y 30
		System.out.println("N�mero aleaotorio entre 10 y 30: "+ (int) Math.floor(Math.random()*21+10));
		
		// Generar valores entre 12 y 20
		System.out.println("N�mero aleaotorio entre 12 y 20: "+ (int) Math.floor(Math.random()*9+12));
		
		// Generar las caras de un dado
		System.out.println("Dado: "+(int) Math.floor(Math.random()*6+1));
		
		
		// ----------------------------------------------------------
		// Prueba del la clase Random
		// ----------------------------------------------------------
		// Crear un objeto de la clase Random
		Random obRandom = new Random();
		
		// Generar un n�mero aleatorio entre 1 y 20
		int numero2 = obRandom.nextInt(20); // Genera un valor entre 0..19
		numero2++; // N�mero entre 1 y 20
		System.out.println("N�mero entre 1 y 20: "+numero2);
		
		// Simular una cara de un dado
		System.out.println("Dado: "+(obRandom.nextInt(6)+1));
		
		// Simular la cara de un dado (ERRONEAMENTE)
		int dado = obRandom.nextInt(7);  // Genera valores entre 0 y 6
		  // OJO QUE LA CARA 0 DEL DADO NO EXISTE
			
		
		// Generar valores entre 10 y 30
		System.out.println("N�mero aleatorio entre 10 y 30: "+(obRandom.nextInt(21)+10));
		
		// Generar valores entre 12 y 20
		System.out.println("N�mero aleaotorio entre 12 y 20: "+(obRandom.nextInt(9)+12));
		
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


















