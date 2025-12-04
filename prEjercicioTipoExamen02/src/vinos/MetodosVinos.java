package vinos;

/**
 * A) Clase con los siguientes métodos de clase:
 * 		- Método que obtenga a partir de una cantidad en hectolitros, su equivalente en litros. Un hectolitro
 * 		equivale a 100 litros.
 * 
 * 		- Método que devuelva una cantidad desglosada en euros y céntimos.
 * 		Ejemplo: 12.5 nos devolverá: 12 euros y 50 céntimos
 * 		80 nos devolverá: 80 euros
 */

public class MetodosVinos {

	/**
	 * Método que obtenga a partir de una cantidad en hectolitros, su equivalente en litros.
	 * 		Un hectolitro equivale a 100 litros.
	 */
	public static int conversorHectolitros(int hectolitros) {
		return hectolitros*100;
	}

	/**
	 * Método que devuelva una cantidad desglosada en euros y céntimos.
	 * 		Ejemplo: 12.5 nos devolverá: 12 euros y 50 céntimos
	 * 		80 nos devolverá: 80 euros
	 */
	public static void desglose(float dinero) {
		int euros,centimos;

		euros=(int)dinero;
		centimos=(int) Math.round((dinero - euros) * 100);

		if (centimos!=0) {
			System.out.println(euros + " euros y " + centimos + " céntimos");
		}
		else {
			System.out.println((int)dinero + " euros");
		}
	}
}
