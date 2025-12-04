package jamones;

/**
 * Tenemos un amigo que se dedica a la venta de jamones procedentes de diferentes puntos de España, y
 * nos ha pedido que le echemos una mano para gestionar la venta de los mismos. Consultar anexo sobre los
 * tipos de jamones.
 * 
 * Vamos a organizar para gestionar todo esto con las siguientes clases:
 * 
 * A) Desarrollar una clase que va a contener los siguientes métodos de clase:
 * 
 * 	- Método que devuelva una cantidad desglosada en euros y céntimos.
 * 		Ejemplo: 12.5 nos devolverá: 12 euros y 50 céntimos
 * 		80 nos devolverá: 80 euros
 * 
 * 	- Método que convierte de arrobas a kilos (1 @ equivale a 11.339 kilos)
 * 
 * 	- Método que convierte de kilos a arrobas (1 kilo equivale a 0.088@)
 * 
 * 	- Método que obtiene el precio por kilo, a partir de un precio por arroba.
 * 
 * 	- Método que obtiene el precio de la arroba, a partir del precio por kilo.
 */

public class MetodosJamones {

	private static final float ARROBA = 11.339f;
	private static final float KILOS = 0.088f;
	
	/**
	 * - Método que devuelva una cantidad desglosada en euros y céntimos.
	 * 		Ejemplo: 12.5 nos devolverá: 12 euros y 50 céntimos
	 * 		80 nos devolverá: 80 euros
	 * @param dinero
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

	/**
	 * - Método que convierte de arrobas a kilos (1 @ equivale a 11.339 kilos)
	 */
	public static float conversorKilos(float arrobas) {
		return arrobas*ARROBA;
	}

	/**
	 * - Método que convierte de kilos a arrobas (1 kilo equivale a 0.088@)
	 */
	public static float conversorArrobas(float kilos) {
		return kilos*KILOS;
	}

	/**
	 * - Método que obtiene el precio por kilo, a partir de un precio por arroba.
	 */
	public static float precioPorKilo(float precio, float arrobas) {
		return conversorKilos(arrobas)*precio;
	}

	/**
	 * - Método que obtiene el precio de la arroba, a partir del precio por kilo.
	 */
	public static float precioPorArroba(float precio, float kilos) {
		return conversorArrobas(kilos)*precio;
	}
}
