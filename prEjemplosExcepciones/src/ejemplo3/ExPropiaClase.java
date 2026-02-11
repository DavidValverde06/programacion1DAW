package ejemplo3;

import java.util.Scanner;

/**
 * Clase desde la que se lanza una excepcion del tipo "ExPropia"
 */

public class ExPropiaClase {

	/**
	 * Método que lanza excepciones tipo ExPropia, si el valor tecleado es 0
	 * @throws ExPropia
	 */
	public void metodo() throws ExPropia {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un número, 0 lanza excepción");

		int num = sc.nextInt();
		if (num == 0) {
			sc.close();
			throw new ExPropia();
		}

		sc.close();
	}


	/**
	 * Otra forma de hacer el método, utilizando en este caso un try con recursos
	 * para la apertura del objeto Scanner, de esta forma es el propio try el que
	 * se encarga del cierre del recurso (el objeto Scanner), ahorrándonos tener 
	 * que repetir dos veces la sentencia de cierre.
	 * @throws ExPropia
	 */
	public void metodoV2() throws ExPropia {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Introduzca un número, 0 lanza excepción");
			if (sc.nextInt() == 0) 
				throw new ExPropia();
		}  
	}	
}