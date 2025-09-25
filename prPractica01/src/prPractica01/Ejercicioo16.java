package prPractica01;

/**
 * 16.- Un programa tiene como entrada dos números y los almacena en las variables “u” y “v”. ¿Qué hay que
		hacer par que al final del algoritmo los valores de las variables estén intercambiados? Diseña el
		algoritmo correspondiente.
 */

public class Ejercicioo16 {

	public static void main(String[] args) {

		int u = 1;
		int v = 2;
		int x;
		
		System.out.println("u: " + u +
				   "\nv: " + v);
		x=u;
		u=v;
		v=x;
		
		System.out.println("\nu: " + u +
						   "\nv: " + v);
	}

}
