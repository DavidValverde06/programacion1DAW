package ejercicio4;
import java.util.*;

public class Ejer4Pila {

	public static void main(String[] args) {

		Deque<Integer> miPila = new ArrayDeque<>();

		miPila.addFirst(1);
		miPila.add(2);  // Equivale a addLast
		miPila.push(3);
		miPila.push(4);
		miPila.push(80);

		System.out.println(miPila);

		System.out.println("\nPrimero de la Pila: " + miPila.peek());
		System.out.println("Primero de la Pila: " + miPila.peekFirst());

		System.out.println("\nBorrado del primero: " + miPila.pop());

		System.out.println(miPila);
	}

}
