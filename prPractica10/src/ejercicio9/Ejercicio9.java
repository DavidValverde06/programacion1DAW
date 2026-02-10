package ejercicio9;

import java.util.*;

/**
 * 9.- Crea un diccionario de términos informáticos y su definición, con la ayuda de las colecciones. El diccionario
 * deberá estar ordenado por clave de forma alfabética. Para probarlo, pide al usuario un término y
 * muéstrale su definición
 */
public class Ejercicio9 {

	public static void main(String[] args) {

		Map<String, String> dic = new HashMap<>();

		String termino="";

		try (Scanner sc = new Scanner(System.in)) {

			dic.put("hardware", "parte fisica del ordenador");
			dic.put("software", "programas del ordenador");
			dic.put("cpu", "procesa la informacion");
			dic.put("ram", "memoria temporal");
			dic.put("sistema operativo", "controla el ordenador");
			dic.put("algoritmo", "pasos para resolver un problema");
			dic.put("programa", "conjunto de instrucciones");

			System.out.println(dic);

			System.out.print("Introduce un término: ");
			termino=sc.next();
		}
	}

}
