package edificio;

/**
 * Clase que testea el funcionamiento de las clases Direccion, Edificio, Casa, Colegio y Guarderia
 * 
 * @author David Valverde Barea
 */
public class TestEdificios {

	public static void main(String[] args) {

		// Test dirección
		System.out.println("Direcciones:");
		Direccion dir1 = new Direccion("Avda. Europa", 126, 29210);
		Direccion dir2 = new Direccion("Calle alameda", 2, 29200);

		System.out.println("\t" + dir1);

		System.out.println("\t" + dir2);

		System.out.println(); // Salto de línea

		// Test edificio
		Edificio edificio1 = new Edificio(dir1, 10, 3, 1000);
		Edificio edificio2 = new Edificio("Calle Lucena", 5, 29200, 3, 1, 100);

		System.out.println(edificio1);
		System.out.println();
		System.out.println(edificio2);

		System.out.println(); // Salto de línea

		// Test casa
		Casa casa1 = new Casa(dir1, 6, 2, 120, 2, 1);

		System.out.println(casa1);

		System.out.println(); // Salto de línea

		// Test colegio
		Colegio colegio1 = new Colegio(dir1, 40, 3, 2500, 25, 6);

		System.out.println(colegio1);

		System.out.println(); // Salto de línea

		// Test guarderia
		Guarderia guarderia1 = new Guarderia(dir1, 40, 3, 2500, 25, 6, 50);

		System.out.println(guarderia1);

		/**
		 * TEST DEL EJERCICIO DE LA PRÁCTICA 5
		 * 
		 * A partir de las clases anteriores, realizar un testeo que cree un parque de bomberos que posee un
		 * área de 1000 metros repartidos en dos plantas y con un total de 10 habitaciones; una casa de dos
		 * plantas con una superficie total de 150 metros, repartidos en salón, cocina, 4 dormitorios, y 2 baños;
		 * un colegio con un área de 2000 metros, 3 plantas, 25 habitaciones, 18 clases y 3 oficinas, y por último
		 * una guardería con las características que desees. Una vez creados los edificios, se deberá mostrar toda
		 * la información que se posea de cada uno de ellos.
		 */

	}
}
