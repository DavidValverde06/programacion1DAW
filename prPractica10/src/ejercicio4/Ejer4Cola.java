package ejercicio4;

import java.util.*;

public class Ejer4Cola {

	public static void main(String[] args) {

		Queue<Integer> miCola = new PriorityQueue<>();

		// ----------------------------------------------------------------------------------
		// Tanto add como offer añaden elementos al final de la cola, si la cola es de tamaño
		// restringido es preferible utilizar offer
		miCola.add(1);  // add lanza una excepción si no hay espacio, siempre devuelve true
		miCola.add(2);
		miCola.offer(6); // offer devuelve true o false
		miCola.offer(4); 
		miCola.offer(76);
		miCola.add(3);
		miCola.add(5);
		miCola.add(9);  

		System.out.println(miCola);  // Falla a la hora de mostrarlo, lo cual es lógico, ya 
		// que de una cola sólo deberíamos ver el primer elemento
		while (!miCola.isEmpty()) {  // Si voy sacando los elmentos si va bien
			
			System.out.print(miCola.poll()+ " ");
		}

		// ----------------------------------------------------------------------------------
		// Para consultar el primer elemento de la cola (sin borrarlo) tenemos element (lanza
		// excepciones) y peek
		System.out.println("Primer elemento de la cola: " + miCola.peek());
		System.out.println("Primer elemento de la cola: " + miCola.element());

		// ----------------------------------------------------------------------------------
		// Para borrar elementos tenemos remove (lanza una excepción si no hay elementos) o 
		// poll, que devuelve null si no hay elementos
		Integer primero = miCola.poll();
		Integer segundo = miCola.remove();
		System.out.println("Elementos eliminados: " + primero + " y " + segundo);
		System.out.println(miCola);
	}

}
