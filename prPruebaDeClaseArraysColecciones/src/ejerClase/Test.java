package ejerClase;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		Grupo miClase = new Grupo(20);

		System.out.println("Lista completa sin ordenar");
		System.out.println(miClase.getLista());

		System.out.println("\nLista de clase ordenada alfabéticamente");
		System.out.println(miClase.toString());  // Devolverá la lista completa ordenada alfabéticamente

		System.out.println("\nLista de suspensos");
		System.out.println(Arrays.toString(miClase.getSuspensos()));

		System.out.println("\nLista de aprobados ordenada por nota");
		System.out.println(miClase.getAprobados());
	}
}
