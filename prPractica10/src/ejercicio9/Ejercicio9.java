package ejercicio9;

import java.util.*;

/**
 * 9.- Crea un diccionario de términos informáticos y su definición, con la ayuda de las colecciones. El diccionario
 * deberá estar ordenado por clave de forma alfabética. Para probarlo, pide al usuario un término y
 * muéstrale su definición
 */
public class Ejercicio9 {

	public static void main(String[] args) {

		SortedMap<String, String> dic = new TreeMap<>();

		String termino="", continuar="s";

		try (Scanner sc = new Scanner(System.in)) {

			// Añadir palabras al diccionario
			dic.put("hardware", "parte fisica del ordenador");
			dic.put("software", "programas del ordenador");
			dic.put("cpu", "procesa la informacion");
			dic.put("ram", "memoria temporal");
			dic.put("sistema operativo", "controla el ordenador");
			dic.put("algoritmo", "pasos para resolver un problema");
			dic.put("programa", "conjunto de instrucciones");

			// Muestra el diccionario
			System.out.println("=== DICCIONARIO INFORMÁTICO ===");
			System.out.println(dic);

			// Bucle para realizar busquedas en el diccionario
			System.out.print("\n=== Busqueda de términos del diccionario ===");
			do {
				System.out.print("\nIntroduce un término: ");
				termino=sc.next().toLowerCase();

				if (dic.containsKey(termino)) {
					System.out.println(dic.get(termino) + "\n");
				}
				else {
					System.out.println("El término no se encuentra aún en el diccionario\n");
				}

				System.out.print("¿Quieres continuar buscando? (s/n): ");
				continuar = sc.next();
			}
			while (continuar.equalsIgnoreCase("s"));

			System.out.println("\nSaliendo del diccionario...");
		}
	}

}
