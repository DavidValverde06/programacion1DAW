package coche;

public class TestCoche {

	public static void main(String[] args) {

		// Constructor por defecto
		Coche coche1 = new Coche();
		coche1.setModelo("Ibiza");
		coche1.setFabricante("SEAT");
		coche1.setPrecioSinIva(15000.0f);
		coche1.setPorcentajeDeIva((byte) 21);

		// Constructor con todos los parámetros
		Coche coche2 = new Coche("Clio", "Renault", 16000.0f, (byte)21);

		// Constructor con modelo, fabricante y precio
		Coche coche3 = new Coche("Golf", "Volkswagen", 20000.0f);
		coche3.setPorcentajeDeIva((byte) 19); // IVA asignado manualmente

		// Mostrar información con toString()
		System.out.println("Información del coche 1:");
		System.out.println(coche1);
		System.out.println();

		System.out.println("Información del coche 2:");
		System.out.println(coche2);
		System.out.println();

		System.out.println("Información del coche 3:");
		System.out.println(coche3);
		System.out.println();

		// Usar el método consulta()
		System.out.println("Consulta del coche 1:");
		coche1.consulta();
		System.out.println("\n");

		// Comparar coches con equals()
		System.out.println("¿Coche 2 y coche 3 son iguales?");
		System.out.println(coche2.equals(coche3) ? "Son iguales" : "Son distintos");
		System.out.println();

		// Actualizar precio sin IVA
		System.out.println("Precio sin IVA original de coche 2: " + coche2.getPrecioSinIva());
		float nuevoPrecioSubido = coche2.actualizarPrecioSubir((byte) 10);
		System.out.println("Precio tras subir 10%: " + nuevoPrecioSubido);
		float nuevoPrecioBajado = coche2.actualizarPrecioBajar((byte) 5);
		System.out.println("Precio tras bajar 5%: " + nuevoPrecioBajado);
		System.out.println();

		// Modificar atributos
		coche3.setModelo("Golf GTI");
		coche3.setPrecioSinIva(22000.0f);
		System.out.println("Coche 3 modificado:");
		System.out.println(coche3);

		/**
		 * Modifica la clase TestCoche y llama al método precioReal para alguno de los objetos, ¿qué ocurre?.
		 * ¿Puedes cambiar el valor de las variables miembro modelo y precio desde la clase TestCoche? ¿Por qué
		 * puedes cambiar el valor de la variable porcentaje de iva desde TestCoche?
		 */
	}

}
