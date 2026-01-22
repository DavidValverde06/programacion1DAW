package prPractica09;

import java.util.Objects;
import java.util.Random;

/**
 * 1.- Crea un objeto de la clase Random, a continuación, genera un número aleatorio, y por último busca algún
 * método que te informe del nombre de la clase a la que pertenece un objeto, así como del nombre del
 * paquete.
 * 
 * Averigua cómo se usa y para qué sirve el método nanoTime de la clase System. ¿Podría servirnos para
 * averiguar cuánto tarda en ejecutarse un determinado método, y así comprobar si es más o menos
 * eficiente?
 * 
 * Realiza alguna prueba con los métodos de las clases Object y Objects.
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Random rand = new Random();

		int numRandom = rand.nextInt(100); // Número random entre 1 y 100
		long inicio = System.nanoTime();

		System.out.println("Número random entre 1 y 100: " + numRandom);

		System.out.println("\nNombre de la clase a la que pertence el objeto: " + rand.getClass().getSimpleName() + "\n");

		// System.nanoTime es un reloj interno de la maquina virtual de java que sirve para medir el tiempo transcurrido.
		long tiempo = System.nanoTime() - inicio;
		System.out.println("Tiempo: " + tiempo + " ns");

		// Pruebas con métodos de Object 
		System.out.println("\n=== Pruebas con Object ==="); 
		System.out.println("toString(): " + rand.toString()); 
		System.out.println("hashCode(): " + rand.hashCode()); 
		System.out.println("equals(rand): " + rand.equals(rand)); 

		// Pruebas con Objects 
		System.out.println("\n=== Pruebas con Objects ==="); 
		System.out.println("Objects.isNull(rand): " + Objects.isNull(rand)); 
		System.out.println("Objects.nonNull(rand): " + Objects.nonNull(rand)); 
		System.out.println("Objects.equals(rand, rand): " + Objects.equals(rand, rand));
	}

}
