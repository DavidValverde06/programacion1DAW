package ejercicio7;

import java.util.*;

/**
 * 7.- Crea una interfaz InterfazPila, con los métodos pop, push, isVacia y cima.
 * 
 * Implementa esta interfaz en la clase Pila, en la cual los elementos de la pila se guardarán en una 
 * colección tipo List o Deque, os aconsejo que lo hagáis con ambas.
 * 
 * Utilizando alguna de estas clases, hacer un programa para evaluar una expresión aritmética escrita en
 * notación postfija e introducida desde teclado. También podéis hacer un algoritmo que compruebe 
 * si una cadena está correctamente balanceada en paréntesis.
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		Deque<String> pila = new LinkedList<>();

		// push
		pila.push("Hola");
		pila.push("Adios");
		System.out.println(pila);

		// pop
		pila.pop();
		System.out.println(pila);

		// isEmpty
		System.out.println(pila.isEmpty());
		pila.pop();
		System.out.println(pila);
		System.out.println(pila.isEmpty());

		// peek
		pila.push("David");
		pila.push("Si");
		System.out.println(pila.peek());
	}

}
