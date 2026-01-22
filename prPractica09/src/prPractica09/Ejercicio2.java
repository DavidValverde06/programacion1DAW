package prPractica09;

/**
 * 2.- Prueba el funcionamiento de algunos de los métodos de la clase Math, y además:
 * • Genera un número aleatorio entre 1 y 25 utilizando la clase Math.
 * • Calcula la raíz cúbica del número 13 y de 125.
 * • Para qué sirve el método IEEERemainder.
 * • Para qué sirve el método signum, prueba con distintos valores.
 * • Calcula la hipotenusa de un triángulo según el Teorema de Pitágoras.
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		// Genera un número aleatorio entre 1 y 25 utilizando la clase Math.
		System.out.println("Número aleatorio entre 1 y 25: " + (int)((Math.random()*25)+1) + "\n");

		// Calcula la raíz cúbica del número 13 y de 125.
		System.out.println("Raíz cubica del número 13: " + Math.cbrt(13));
		System.out.println("Raíz cubica del número 125: " + Math.cbrt(125));

		// Para qué sirve el método IEEERemainder.
		// Devuelve el resto según la norma IEEE 754, que usa el entero más cercano al cociente para calcularlo.
		System.out.println("\nResto de 5 entre 2: " + Math.IEEEremainder(5, 2));

		// Para qué sirve el método signum, prueba con distintos valores.
		// Devuelve el signo del número.
		// 0 devuelve 0
		// -1 si es menor a 0
		// 1 si es mayor a 0
		System.out.println("\n" + Math.signum(-9));
		System.out.println(Math.signum(9));
		System.out.println(Math.signum(0));
		System.out.println(Math.signum(-0));

		// Calcula la hipotenusa de un triángulo según el Teorema de Pitágoras.
		// Cateto 1: 7 cm
		// Cateto 2: 24 cm
		System.out.println("\nHipotenusa de un triángulo: " + Math.hypot(7, 24));
	}

}
