package prPractica09;

/**
 * 3.- Indica varias formas de poder obtener como tipo primitivo un número dado en una cadena cuyo contenido
 * es “67.235”. Prueba también cómo funciona autoboxing y unboxing.
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		String numeroCadena = "67.235";

		System.out.println("Cadena a Float: " + Float.parseFloat(numeroCadena));
		System.out.println("Cadena a Double: " + Double.parseDouble(numeroCadena));
		System.out.println("Cadena a Entero: " + (int)(Double.parseDouble(numeroCadena)));
		System.out.println("Cadena a Double quitando decimales: " + Math.round(Double.parseDouble(numeroCadena)));

		// Autoboxing.
		// Es el proceso por el cual un tipo primitivo se convierte automáticamente en su clase
		// envoltorio correspondiente cuando es necesario.
		int num = 10;
		Integer numWrapper = num;
		System.out.println("\n" + num);
		System.out.println(numWrapper + "\n");

		// Unboxing.
		// Es el proceso inverso, en el que un objeto de una clase envoltorio se convierte
		// automáticamente en el tipo primitivo que representa.
		Integer numWrapper2 = 20;
		int num2 = numWrapper2;
		System.out.println(num2);
		System.out.println(numWrapper2);
	}

}
